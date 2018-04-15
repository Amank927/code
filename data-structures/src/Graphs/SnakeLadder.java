package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder
{
    public static void main(String[] args)
    {
        // Let us construct the board given in above diagram
        int N = 30;
        int[] moves = new int[N];
        boolean[] visited = new boolean[N];
        int[] length = new int[N];

        for (int i = 0; i<N; i++) {
            moves[i] = -1;
            visited[i] = false;
            length[i] = 0;
        }
        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;
        bfs(moves, visited, length );
        System.out.println(length[29]);

    }
    public static void bfs(int arr[], boolean visited[], int length[])
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(new Integer(0));
        visited[0] = true;
        length[0] = 0;
        while (!queue.isEmpty()) {
            Integer qentry = queue.remove();

            for (int i=1; i<=6 ;i++ )
            {
                int src = qentry.intValue();
                if (src + i < 30 && !visited[src + i]) {
                    if (src + i == 25 ) {
                        System.out.println("debug");
                    }
                    if ( arr[src + i] == -1) {
                        length[src + i] = length[src] + 1;
                        visited[src + i] = true;
                        queue.add(new Integer(src + i));
                    } else {
                        length[arr[src+i]] = length[src] + 1;
                        visited[arr[src +i]] = true;
                        queue.add(new Integer(arr[src + i]));
                    }
                }
            }
        }
    }

}
