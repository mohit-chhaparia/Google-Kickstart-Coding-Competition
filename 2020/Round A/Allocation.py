T = int(input())
j = 1
while T > 0:
    N, B = map(int, input().split())
    PriceArray = list(map(int, input().split()))
    ans = 0
    PriceArray.sort()
    for i in PriceArray:
        if i <= B:
            B -= i
            ans += 1
    print("Case #{}: {}".format(j, ans))
    T -= 1
    j += 1
