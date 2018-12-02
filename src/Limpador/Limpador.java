//package Limpador;

import java.util.LinkedList;

class Limpador{

    public static void main(String []args){

        System.out.println(match_address("Ow Joao. Enfi4 um gostosinho, rua pires da mota, 222, apt. 23B seu arrombz :D"));
    }
    
    public static boolean match_description(String s){
    	if(!match_address(s)&&!match_celphone(s)&&!match_email(s)){
    		return false;
    	}
    	return true;
    }
    public static boolean match_email(String s){
        boolean match = false;
        LinkedList<String> email_regexp= new LinkedList<>();
        email_regexp.add("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
        email_regexp.add("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        email_regexp.add("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        email_regexp.add("[\\w-]+@([\\w-]+\\.)+[\\w-]+");
        email_regexp.add("^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$");
        email_regexp.add("^[\\w\\.=-]+@[\\w\\.-]+\\.[\\w]{2,3}$");
        email_regexp.add("^(\\w+?@\\w+?\\x2E.+)$");
        email_regexp.add("^([\\w\\-\\.]+)@((\\[([0-9]{1,3}\\.){3}[0-9]{1,3}\\])|(([\\w\\-]+\\.)+)([a-zA-Z]{2,4}))$");
        email_regexp.add("^(([-\\w \\.]+)|(&quot;&quot;[-\\w \\.]+&quot;&quot;) )?&lt;([\\w\\-\\.]+)@((\\[([0-9]{1,3}\\.){3}[0-9]{1,3}\\])|(([\\w\\-]+\\.)+)([a-zA-Z]{2,4}))&gt;$");
        email_regexp.add("^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.(([0-9]{1,3})|([a-zA-Z]{2,3})|(aero|coop|info|museum|name))$");
        email_regexp.add("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
        email_regexp.add("^.+@[^\\.].*\\.[a-z]{2,}+.*$");
        email_regexp.add("^[\\w-]+(?:\\.[\\w-]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7}$");
        email_regexp.add("^[\\w-]+(\\.[\\w-]+)*@([a-z0-9-]+(\\.[a-z0-9-]+)*?\\.[a-z]{2,6}|(\\d{1,3}\\.){3}\\d{1,3})(:\\d{4})?$");
        email_regexp.add("^(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\\-+)|([A-Za-z0-9]+\\.+)|([A-Za-z0-9]+\\++))*[A-Za-z0-9]+@((\\w+\\-+)|(\\w+\\.))*\\w{1,63}\\.[a-zA-Z]{2,6}$");

        for(String regexp: email_regexp){
            if(s.matches(regexp)){
                match = true;
                break;
            }
        }
        return match;
    }
    public static boolean match_address(String s){
        return s.matches("^.*(RUA|Rua|R.|rua|AVENIDA|Avenida|AV.|av.|avenida|TRAVESSA|Travessa|TRAV.|Trav.|trav.|travessa).+[, ]+([0-9]*)\\s?([-/\\da-zDA-Z\\\\ ]+)?+.*$");
    }

    public static boolean match_celphone(String s){
        boolean match = false;
        LinkedList<String> cel_regexp = new LinkedList<>();
        cel_regexp.add("^.*[0-9]{8,9}+.*$");
        cel_regexp.add("^.*[0-9]{4,5}\\-[0-9]{4}+.*$");
        cel_regexp.add("^.*[0-9]{10,11}+.*$");
        cel_regexp.add("^.*[0-9]{6,7}\\-[0-9]{4}+.*$"); 
        cel_regexp.add("^.*[0-9]{11,12}+.*$");
        cel_regexp.add("^.*[0-9]{7,8}\\-[0-9]{4}+.*$"); 
        cel_regexp.add("^.*\\([0-9]{2}\\)[0-9]{8,9}+.*$");
        cel_regexp.add("^.*\\([0-9]{2}\\)[0-9]{4,5}\\-[0-9]{4}+.*$");

        for(String regex: cel_regexp){
            if(s.matches(regex)){
                match=true;
                break;
            }
        }

        return match;
    }
}