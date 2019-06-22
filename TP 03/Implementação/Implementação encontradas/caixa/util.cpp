#include "util.h"

string escape(const string& s)
{
   string t{"\""};
   for (const char c : s)
      switch (c)
      {
         case '\\': t += "\\\\"; break;
         case '"' : t += "\\\""; break;
         case '\n': t += "\\n";  break;
         case '\t': t += "\\t";  break;
         default  : t += c;
      }
   t += '"';
   return t;
};

istream &unescape(istream &is, string &str)
{
   char c;
   if (is >> c && c == '"')
   {
      string t;
      while (is.get(c) && c != '"')
         if (c == '\\')
         if (is.get(c))
            switch (c)
            {
               case '\\': t += '\\'; break;
               case '"' : t += '"'; break;
               case 'n' : t += '\n'; break;
               case 't' : t += '\t'; break;
               default  : is.setstate(ios_base::failbit); return is;
            }
         else
         {
            is.setstate(ios_base::failbit);
            return is;
         }
         else
            t += c;
      if (c == '"')
         str = t;
   }
   else
      is.setstate(ios_base::failbit);
   return is;
}

istream &word(istream &is, const string &str)
{
   char c;
   for (char x : str)
      if (!(is.get(c) && c == x))
      {
         is.setstate(ios_base::failbit);
         break;
      }
   return is;
}
