#We will store num to its frequency when a dictionary, with it maps the integer to its frequency and a list of times that it was inputted in
class FreqStack:

    def __init__(self):
        self.numToFreqTimes = {} # Dict to store the best states of the num
        self.pq = [] # heap to know what to pop
        self.time = 0 # tracking which came first

    def push(self, val: int) -> None:
        # Update values in the dict
        if val in self.numToFreqTimes: 
            self.numToFreqTimes[val][0] = self.numToFreqTimes.get(val)[0] - 1
            self.numToFreqTimes[val][1].append(self.time)
        else:
            self.numToFreqTimes[val] = [-1, [self.time], val]

        # Add to heap
        heapq.heappush(self.pq, (self.numToFreqTimes[val][0], -self.numToFreqTimes[val][1][-1], val))

        # Add to time
        self.time += 1

    def pop(self) -> int:
        # Grab the first time
        res = heapq.heappop(self.pq)

        # Update everything in the dict state
        self.numToFreqTimes[res[2]][0] += 1
        self.numToFreqTimes[res[2]][1].pop()

        # Return goods
        return res[2]



# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()