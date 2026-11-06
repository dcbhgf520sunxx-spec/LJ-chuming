import { b as h } from "./machine-part-85f162b2.js";
import { ref as p } from "vue";
function N(m) {
  const u = p([]), i = p(false);
  async function f() {
    try {
      i.value = true;
      const { content: o } = await h(m.value);
      console.log(o);
      const c = 6, l = [];
      for (let s = 0; s < o.length; s++) {
        const e = o[s];
        e.list = e.list || [];
        let r = c, a = [];
        for (let t = 0; t < e.list.length; t++) {
          const n = e.list[t];
          a.push({ groupName: n.groupName, workShopName: n.workShopName, productionLineName: n.productionLineName, quantity: n.quantity, boolDrillEnum: n.boolDrillEnum }), r--, r === 0 && (l.push({ productionLineList: a, serialNumber: null, picturePath: null }), a = [], r = c);
        }
        if (r > 0) {
          for (let t = 0; t < r; t++) a.push({});
          l.push({ productionLineList: a, serialNumber: e.serialNumber, picturePath: e.picturePath });
        }
      }
      console.log({ _separateList: l }), u.value = l || [];
    } catch (o) {
      console.log("获取零件分拣单失败", o);
    } finally {
      i.value = false;
    }
  }
  return { separateLoading: i, separateOrderInfo: u, fetchSeparateOrder: f };
}
export {
  N as u
};
