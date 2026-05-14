class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/");

        for(String s : str){

            if(s.equals("") || s.equals(".")){
                continue;

            }else if(s.equals("..")){

                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(s);
            }
        }
        if(stack.isEmpty())return "/";

        StringBuilder sb = new StringBuilder();

        for(String dir : stack){
            sb.append("/").append(dir);
        }
        return sb.toString();
        
    }
}