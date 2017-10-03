public class getvalues{
	public static void main(String[] args){	
		String in = "{index : cassini, _id : testing, index : another}}";
		Integer strlength = in.length();
		String sstring = "index";
		int checklength = in.length() - sstring.length();
		int valuecount = 0;
		int retvalue = 2;

		for(int i = 0; i <= checklength; i++){
			String singlechar = ""+in.charAt(i);
			String schar = ""+sstring.charAt(0);
			if(schar.equalsIgnoreCase(singlechar)){
				String rstring = schar;
				int startstring = 0;
				for(int x = 1; x < sstring.length(); x++){
					int y = i + x;
					String checkstring = ""+in.charAt(y);
					schar = schar + checkstring;
					startstring = x;
				}
				if(schar.equalsIgnoreCase(sstring)){
				//System.out.println("found whole:"+schar);
				// find corresponding value
				for(int xy = 0; xy < checklength; xy++){
					int checkindex = i + startstring + xy;
					String checkforcolon = ""+in.charAt(checkindex);
					int anostartstring = 0;
					if(checkforcolon.equals(":")){
					//System.out.println("found colon:"+checkforcolon);
					anostartstring = xy;
					for(int xyz = 0; xyz < checklength; xyz++){
						int xxx = i + anostartstring + xyz;
						String chkstr = ""+in.charAt(xxx);
						//String chkstr2 = ""+in.charAt(xxx+1);
						if(chkstr.equals(" ")){
						String chkcolon = ""+in.charAt(xxx+1);
						if(chkcolon.equals(":")){
							// get first char back of the value
							int firstvaluecharindex = xxx + 3;
							String valueis = ""+in.charAt(firstvaluecharindex);
							//System.out.println("found space and colon!:"+valueis);
							for(int abb = firstvaluecharindex; abb < in.length(); abb++){
								String checkcomma = ""+in.charAt(abb);
								//System.out.println("f:"+in.charAt(abb));
								if(checkcomma.contains(",") || checkcomma.contains("}")){
									//System.out.println("found comma or }");
									String actvalueis = in.substring(firstvaluecharindex,abb);
									valuecount++;
									if(valuecount >= retvalue){
										System.out.println("hey:"+actvalueis);
									};
									break;
								} 
							}	
						}
						break;
						}
					};
					break;
					}
				}
			};				
		}

	}

}
}
