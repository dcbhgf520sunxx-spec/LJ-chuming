import { e2 as c } from "../shared/runtime.js";
import { a as l, b as m } from "./payment-settlement-a7865af1.js";
import { ref as s } from "vue";
function j({ form: i = {} }) {
  const u = s([]), p = s([]), o = s([]), n = s([]);
  return { projectAllInfoData: u, projectList: p, supplierList: o, contractNoList: n, getSupplierList: async () => {
    try {
      const t = await l();
      if (!t || Object.keys(t).length === 0) {
        o.value = [], c("warning", "暂无供应商");
        return;
      }
      o.value = Object.entries(t).map(([e, r]) => ({ id: Number(e), value: r, name: r }));
    } catch (t) {
      console.log("获取供应商失败:", t);
    }
  }, getPurchaseContractNumber: async (t) => {
    try {
      const e = await m({ supplierId: i.supplierId, ...t });
      if (!e || Object.keys(e).length === 0) {
        c("warning", "该供应商下暂无合同号"), n.value = [];
        return;
      }
      n.value = Object.entries(e).map(([r, a]) => ({ id: Number(r), name: a })).sort((r, a) => a.id - r.id);
    } catch (e) {
      console.error("获取采购合同列表失败:", e);
    }
  } };
}
export {
  j as u
};
