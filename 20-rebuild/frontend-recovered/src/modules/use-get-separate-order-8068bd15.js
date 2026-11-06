import { l as i } from "../shared/runtime.js";
import { ref as m } from "vue";
function h(e) {
  return i({ module: "bridge", url: "task/order/machinePart/page", method: "get", params: e });
}
function N(e) {
  return i({ module: "bridge", url: "task/order/nesting", method: "get", responseType: "blob", params: e });
}
function k(e) {
  return i({ module: "bridge", url: "task/order/drilling", method: "get", params: e });
}
function f(e) {
  return i({ module: "bridge", url: "machine_part/separate", method: "get", params: e });
}
function v(e) {
  return i({ module: "bridge", url: "machine_part/separate/print/sign", method: "get", params: e });
}
const y = { get: h };
function S(e) {
  const p = m([]), l = m(false);
  async function g() {
    try {
      l.value = true;
      const { content: o } = await f(e.value);
      console.log(o);
      const d = 6, u = [];
      for (let c = 0; c < o.length; c++) {
        const t = o[c];
        t.list = t.list || [];
        let n = d, a = [];
        for (let r = 0; r < t.list.length; r++) {
          const s = t.list[r];
          a.push({ groupName: s.groupName, workShopName: s.workShopName, productionLineName: s.productionLineName, quantity: s.quantity }), n--, n === 0 && (u.push({ productionLineList: a, serialNumber: null, picturePath: null }), a = [], n = d);
        }
        if (n > 0) {
          for (let r = 0; r < n; r++) a.push({});
          u.push({ productionLineList: a, serialNumber: t.serialNumber, picturePath: t.picturePath });
        }
      }
      console.log({ _separateList: u }), p.value = u || [];
    } catch (o) {
      console.log("获取零件分拣单失败", o);
    } finally {
      l.value = false;
    }
  }
  return { separateLoading: l, separateOrderInfo: p, fetchSeparateOrder: g };
}
export {
  v as a,
  y as c,
  k as p,
  N as s,
  S as u
};
