package ms1707;

import java.util.*;

class Solution {

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Item> nameMap = new HashMap<>();

        for (String synonym : synonyms) {
            int index = synonym.indexOf(',');
            String first = synonym.substring(1, index);
            String second = synonym.substring(index + 1, synonym.length() - 1);

            if (first.compareTo(second) > 0) {
                String temp = first;
                first = second;
                second = temp;
            }

            Item firstItem = nameMap.computeIfAbsent(first, (k) -> new Item(null));

            String finalFirst = first;
            nameMap.compute(second, (k, v) -> {
               if (v == null) {
                   return new Item(finalFirst);
               } else {
                   if (v.next == null) {
                       v.next = finalFirst;
                   } else if (finalFirst.compareTo(v.next) < 0) {
                       v.next = finalFirst;
                   }
                   return v;
               }
            });
        }

        for (String name : names) {
            int i = name.length() - 2;
            int p = 1;
            int count = 0;

            while (name.charAt(i) != '(') {
                count += (name.charAt(i) - '0') * p;
                p *= 10;
                i--;
            }

            String na = name.substring(0, i);

            Item item = nameMap.get(na);

            if (item == null) {
                item = new Item(null);
                nameMap.put(na, item);
            }

            while (item.next != null) {
                item = nameMap.get(item.next);
            }

            item.count += count;
        }

        List<String> ans = new ArrayList<>();
        nameMap.forEach((k, v) -> {
            if (v.next == null) {
                ans.add(k + "(" + v.count + ")");
            }
        });

        return ans.toArray(new String[0]);
    }

    static class Item {
        String next;
        int count;

        public Item(String next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {
        String[] rs = new Solution().trulyMostPopular(
                new String[]{"Fcclu(70)","Ommjh(63)","Dnsay(60)","Qbmk(45)","Unsb(26)","Gauuk(75)","Wzyyim(34)","Bnea(55)","Kri(71)","Qnaakk(76)","Gnplfi(68)","Hfp(97)","Qoi(70)","Ijveol(46)","Iidh(64)","Qiy(26)","Mcnef(59)","Hvueqc(91)","Obcbxb(54)","Dhe(79)","Jfq(26)","Uwjsu(41)","Wfmspz(39)","Ebov(96)","Ofl(72)","Uvkdpn(71)","Avcp(41)","Msyr(9)","Pgfpma(95)","Vbp(89)","Koaak(53)","Qyqifg(85)","Dwayf(97)","Oltadg(95)","Mwwvj(70)","Uxf(74)","Qvjp(6)","Grqrg(81)","Naf(3)","Xjjol(62)","Ibink(32)","Qxabri(41)","Ucqh(51)","Mtz(72)","Aeax(82)","Kxutz(5)","Qweye(15)","Ard(82)","Chycnm(4)","Hcvcgc(97)","Knpuq(61)","Yeekgc(11)","Ntfr(70)","Lucf(62)","Uhsg(23)","Csh(39)","Txixz(87)","Kgabb(80)","Weusps(79)","Nuq(61)","Drzsnw(87)","Xxmsn(98)","Onnev(77)","Owh(64)","Fpaf(46)","Hvia(6)","Kufa(95)","Chhmx(66)","Avmzs(39)","Okwuq(96)","Hrschk(30)","Ffwni(67)","Wpagta(25)","Npilye(14)","Axwtno(57)","Qxkjt(31)","Dwifi(51)","Kasgmw(95)","Vgxj(11)","Nsgbth(26)","Nzaz(51)","Owk(87)","Yjc(94)","Hljt(21)","Jvqg(47)","Alrksy(69)","Tlv(95)","Acohsf(86)","Qejo(60)","Gbclj(20)","Nekuam(17)","Meutux(64)","Tuvzkd(85)","Fvkhz(98)","Rngl(12)","Gbkq(77)","Uzgx(65)","Ghc(15)","Qsc(48)","Siv(47)"},
                new String[]{"(Gnplfi,Qxabri)","(Uzgx,Siv)","(Bnea,Lucf)","(Qnaakk,Msyr)","(Grqrg,Gbclj)","(Uhsg,Qejo)","(Csh,Wpagta)","(Xjjol,Lucf)","(Qoi,Obcbxb)","(Npilye,Vgxj)","(Aeax,Ghc)","(Txixz,Ffwni)","(Qweye,Qsc)","(Kri,Tuvzkd)","(Ommjh,Vbp)","(Pgfpma,Xxmsn)","(Uhsg,Csh)","(Qvjp,Kxutz)","(Qxkjt,Tlv)","(Wfmspz,Owk)","(Dwayf,Chycnm)","(Iidh,Qvjp)","(Dnsay,Rngl)","(Qweye,Tlv)","(Wzyyim,Kxutz)","(Hvueqc,Qejo)","(Tlv,Ghc)","(Hvia,Fvkhz)","(Msyr,Owk)","(Hrschk,Hljt)","(Owh,Gbclj)","(Dwifi,Uzgx)","(Iidh,Fpaf)","(Iidh,Meutux)","(Txixz,Ghc)","(Gbclj,Qsc)","(Kgabb,Tuvzkd)","(Uwjsu,Grqrg)","(Vbp,Dwayf)","(Xxmsn,Chhmx)","(Uxf,Uzgx)"}
        );
        Arrays.sort(rs);

        System.out.println(Arrays.toString(rs));

        String[] expect = new String[] {"Npilye(25)","Drzsnw(87)","Fpaf(219)","Axwtno(57)","Avmzs(39)","Knpuq(61)","Avcp(41)","Naf(3)","Aeax(646)","Kgabb(236)","Chhmx(259)","Dwifi(237)","Ofl(72)","Nzaz(51)","Msyr(211)","Csh(238)","Kufa(95)","Ebov(96)","Onnev(77)","Chycnm(253)","Bnea(179)","Yjc(94)","Koaak(53)","Gauuk(75)","Hfp(97)","Jfq(26)","Dnsay(72)","Hljt(51)","Ibink(32)","Obcbxb(124)","Alrksy(69)","Qbmk(45)","Qiy(26)","Uvkdpn(71)","Unsb(26)","Weusps(79)","Fvkhz(104)","Fcclu(70)","Gnplfi(109)","Jvqg(47)","Mtz(72)","Ucqh(51)","Ntfr(70)","Nsgbth(26)","Hcvcgc(97)","Oltadg(95)","Nuq(61)","Kasgmw(95)","Nekuam(17)","Dhe(79)","Okwuq(96)","Qyqifg(85)","Mcnef(59)","Ijveol(46)","Acohsf(86)","Gbkq(77)","Mwwvj(70)","Yeekgc(11)","Ard(82)"};
        Arrays.sort(expect);
        System.out.println(Arrays.toString(expect));
    }
}
