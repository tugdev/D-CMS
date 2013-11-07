clear all; close all; clc;

im = imread('bonibon.jpg');

r = im(:,:, 1); % renk kanallarý olusturuluyor
g = im(:,:, 2);
b = im(:,:, 3);


bwr1 = abs(double(r)-50) <= 50;
bwg1 = abs(double(g)-70) <=70;
bwb1 = abs(double(b)-175) <=60;
bw1 = bwr1 .* bwg1 .* bwb1;

bw1 = cat(3, bw1,bw1,bw1);
img1 = uint8(double(im) .* bw1);


bwr2 = abs(double(r) - 230) <= 30;
bwg2 = abs(double(g) -225) <=30;
bwb2 = abs(double(b) -40) <=40;
bw2 = bwr2 .* bwg2 .* bwb2;

bw2 = cat(3, bw2,bw2,bw2);
img2 = uint8(double(im) .* bw2);


bwr3 = abs(double(r) - 230) <= 30;
bwg3 = abs(double(g) -100) <=42;
bwb3 = abs(double(b) -55) <=56;
bw3 = bwr3 .* bwg3 .* bwb3;

bw3 = cat(3, bw3,bw3,bw3);
img3 = uint8(double(im) .* bw3);


bwr4 = abs(double(r) - 170) <= 40;
bwg4 = abs(double(g)) <= 50;
bwb4 = abs(double(b)) <= 136;
bw4 = bwr4 .* bwg4 .* bwb4;

bw4 = cat(3, bw4,bw4,bw4);
img4 = uint8(double(im) .* bw4);


bwr5 = abs(double(r)) <= 100;
bwg5 = abs(double(g)) <=60;
bwb5 = abs(double(b)) <=85;
bw5 = bwr5 .* bwg5 .* bwb5;

bw5 = cat(3, bw5,bw5,bw5);
img5 = uint8(double(im) .* bw5);


bwr6 = abs(double(r) - 80) <= 90;
bwg6 = abs(double(g) -240) <=80;
bwb6 = abs(double(b) -60) <=80;
bw6 = bwr6 .* bwg6 .* bwb6;

bw6 = cat(3, bw6,bw6,bw6);
img6 = uint8(double(im) .* bw6);


figure(1);
subplot(3,2,1); imshow(img1); title('Mavi');
subplot(3,2,2); imshow(img2); title('Sari');
subplot(3,2,3); imshow(img3); title('Turuncu');
subplot(3,2,4); imshow(img4); title('Kýrmýzý');
subplot(3,2,5); imshow(img5); title('Siyah');
subplot(3,2,6); imshow(img6); title('Yeþil');






