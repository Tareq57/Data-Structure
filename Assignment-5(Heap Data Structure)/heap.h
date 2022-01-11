#include <vector>
#include<iostream>
using namespace std;
class Heap
{

    int maxsize;
    int *ara;
    int curr = 0;
    void percolecon(int i)
    {
        int parent_key = i / 2;
        if (parent_key > 0 and ara[parent_key] < ara[i])
        {
            swap(ara[parent_key], ara[i]);
            percolecon(parent_key);
        }
    }
    void heapify(int i, int n)
    {
        int l = 2 * i;
        int r = 2 * i + 1;
        int largest = i;
        if (l <= n and ara[l] < ara[largest])
            largest = l;
        if (r <= n and ara[r] < ara[largest])
            largest = r;
        if (largest != i)
        {
            swap(ara[largest], ara[i]);
            heapify(largest, n);
        }
    }

public:
    Heap(int size)
    {
        maxsize = size;
        ara = new int[maxsize + 1];
        curr = 0;
    }
    Heap(vector<int> &numbers)
    {
        maxsize = numbers.size();
        ara = new int[maxsize + 1];
        curr = maxsize;
        for (int i = 0; i < numbers.size(); i++)
            ara[i + 1] = numbers[i];
        for (int i = maxsize / 2; i > 0; i--)
            heapify(i, curr);
    }
    ~Heap()
    {
        delete[] ara;
    }
    void insert(int num)
    {
        if(maxsize<=curr)
        return ;
        ara[++curr] = num;
        percolecon(curr);
    }
    int size()
    {
        return curr;
    }
    int getMax()
    {
        return ara[1];
    }
    int deleteKey()
    {
        int val = ara[1];
        swap(ara[1], ara[curr]);
        curr--;
        heapify(1, curr);
        return val;
    }
};
void heapsort(vector<int> &numbers)
{
    Heap hp(numbers);
    int size = hp.size();
    for (int i = 0; i < size; i++)
    {
        hp.deleteKey();
    }
}
