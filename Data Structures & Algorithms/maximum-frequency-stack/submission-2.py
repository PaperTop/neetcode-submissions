#Stack of stacks
class FreqStack:

    def __init__(self):
        self.counts = {}
        self.stacks = []

    def push(self, val: int) -> None:
        # Update the counts
        if val in self.counts:
            self.counts[val] += 1
        else:
            self.counts[val] = 1
        # Push to the stacks of stack depending on if it the longest
        if self.counts[val] > len(self.stacks):
            self.stacks.append([val])
        else:
            self.stacks[self.counts[val] - 1].append(val)

    def pop(self) -> int:
        res = self.stacks[-1].pop()
        # Update stacks
        if len(self.stacks[-1]) == 0:
            self.stacks.pop()

        # Update counts
        self.counts[res] -= 1
        return res
        


# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()