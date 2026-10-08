class Solution:
    def calPoints(self, operations: List[str]) -> int:
        rec = []
        for op in operations:
            if op == '+':
                rec.append(rec[-1] + rec[-2])
            elif op == 'D':
                rec.append(rec[-1] * 2)
            elif op == 'C':
                rec.pop(-1)
            else:
                rec.append(int(op))
            print(rec)

        res = 0
        for score in rec:
            res += score
        
        return res