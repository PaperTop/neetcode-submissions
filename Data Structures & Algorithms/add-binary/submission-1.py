class Solution:
  def addBinary(self, a: str, b: str) -> str:
    i, j, carry = len(a) - 1, len(b) - 1, 0
    res = []

    while i >= 0 or j >= 0 or carry:
      total = carry
      if i >= 0:
        total += 1 if a[i] == "1" else 0
        i -= 1
      if j >= 0:
        total += 1 if b[j] == "1" else 0
        j -= 1

      res.append("1" if total % 2 else "0")
      carry = total // 2

    return "".join(reversed(res))