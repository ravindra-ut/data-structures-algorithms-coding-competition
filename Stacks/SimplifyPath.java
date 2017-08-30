import java.util.*;

class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> st = new LinkedList<>();
        for(String dir: path.split("/")){
            if(dir.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            } else if(!(dir.equals(".") || dir.equals(""))){
                st.push(dir);
            }
        }
        String res = "";
        for(String dir: st){
            res = "/" + dir + res;
        }
        if(st.isEmpty()){
            return "/";
        } else {
            return res;
        }
    }
}