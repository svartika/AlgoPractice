package January

class BoatsToSavePeople {
    private fun partition(people:IntArray, p: Int, r: Int) : Int {
        var x = people[r]
        var i = p-1
        for(j in p..r-1) {
            if(people[j]<=x) {
                i++
                var temp = people[i]
                people[i] = people[j]
                people[j] = temp
            }
        }
        var temp = people[r]
        people[r] = people[i+1]
        people[i+1] = temp
        return i+1
    }

    private fun quickSort(people:IntArray, p: Int, r: Int) {
        if( p<r ) {
            var q = partition(people, p, r)
            quickSort(people, p, q - 1)
            quickSort(people, q+1, r)
        }
    }

    private fun findPartner(people:IntArray, upTo: Int, limit:Int) : Int {
        //var prevI = -1
        for(i in upTo-1 downTo 0) {
            if(people[i]==0) continue
            if(people[i]+people[upTo] <= limit) {
                return i
            } /*else if(people[i]+people[upTo] < limit) {
                return i-1
            } */
           // prevI = i
        }
        //return prevI
        return -1;
    }

    fun numRescueBoats(people: IntArray, limit: Int): Int {
        quickSort(people, 0, people.size-1)
        //print(Arrays.toString(people))
        var numOfBoat=0
        for(i in people.size-1 downTo 0) {
            if(people[i]==0) continue
            if(people[i]!=limit) {
                var j = findPartner(people,i, limit)
                if(j!=-1) {
                    people[j] = 0
                }
            }
            numOfBoat++
        }
        return numOfBoat
  }
}

fun main(args:Array<String>) {
    //var people = intArrayOf(3,5,3,4)
    //var limit = 5

    //var people = intArrayOf(3,2,2,1)
    //var people = intArrayOf(1,2)
    //var limit = 3

    //var people = intArrayOf(2,2)
    //var limit = 6

    var people = intArrayOf(5,1,7,4,2,4)
    var limit = 7


    print(BoatsToSavePeople().numRescueBoats(people, limit))
}