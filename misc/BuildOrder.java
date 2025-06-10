import java.util.*;

public class BuildOrder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int d = sc.nextInt();

        sc.nextLine();
        ArrayList<String> project = new ArrayList<>();
        for(String val:sc.nextLine().split(" ")){
            // System.out.print(val+" ");
            project.add(val);
        }

        ArrayList<ArrayList<String> > dependencies = new ArrayList<>();
        for(int i=0;i<d;i++){
            ArrayList<String> dependency = new ArrayList<>();
            for(String dep:sc.nextLine().split(" ")){
                dependency.add(dep);
            }
            dependencies.add(dependency);
        }
        ArrayList<String> ans = buildOrder(project,dependencies);

        for(String proj:ans){
            System.out.print(proj+" ");
        }
        sc.close();
    }
    public static ArrayList<String> buildOrder(ArrayList<String> project,ArrayList<ArrayList<String> > dependencies){
        HashMap<String, List<String>> adj = new HashMap<>();
        for (int i=0; i<project.size(); i++) {
            String key = project.get(i);
            List<String> value = new ArrayList<>();
            adj.put(key, value);
        }
        for (List<String> edge : dependencies) {
            String u = edge.get(0);
            String v = edge.get(1);

            List<String> val = adj.get(u);
            val.add(v);
            adj.put(u, val);
        }

        HashMap<String, Integer> degree = new HashMap<>();
        for (List<String> edge : dependencies) {
            String v = edge.get(1);
            if (degree.containsKey(v)) {
                degree.put(v, degree.get(v)+1);
            }else {
                degree.put(v, 1);
            }
        }

        Queue<String> q = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : degree.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        ArrayList<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            String proj = q.remove();
            res.add(proj);

            for (String nbr : adj.get(proj)) {
                degree.put(nbr, degree.get(nbr)-1);
                if (degree.get(nbr) == 0) {
                    q.add(nbr);
                }
            }
        }
        return res;
    }

}
