package 学习;

import java.util.*;

public class Graph {
    public static class Node {
        int Value;
        String ID;
        int in;
        int out;
        ArrayList<Edge> edges;
        ArrayList<Node>nexts;
        public Node(int data){
            this.Value=data;
            edges=new ArrayList<>();
            nexts=new ArrayList<>();
        }
    }

    public static class Edge {

        int weight;
        Node from;
        Node to;


        public Edge(Node From,Node To,int Weight){
            this.from=From;
            this.to=To;
            this.weight=Weight;
        }
    }

    public static class graph {
        public HashMap<Integer,Node>nodes;
        public HashSet<Edge>edges;
    }

    public static void BFS(Node head) {
        Queue<Node>queue=new LinkedList<>();
        HashSet<Node>Set=new HashSet<>();
        queue.add(head);
        Set.add(head);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            for(Node next: cur.nexts){
                if(!Set.contains(next)) {
                    queue.add(next);
                    Set.add(cur);
                }
            }
            System.out.print(cur.Value);
        }
    }
    public static void DFS(Node head){
        if(head==null){
            return;
        }
        Stack<Node>Mystack=new Stack<>();
        HashSet<Node>Set=new HashSet<>();
        Mystack.push(head);
        Set.add(head);
        while(!Mystack.isEmpty()){
            Node cur=Mystack.pop();
            for(Node next: cur.nexts){
                if(!Set.contains(next)){
                    Mystack.push(cur);
                    Mystack.push(next);
                    Set.add(next);
                    System.out.print(next.Value);
                    break;
                }
            }
        }
    }
}
