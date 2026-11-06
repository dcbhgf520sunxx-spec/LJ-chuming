import { e2 as i } from "../shared/runtime.js";
import { g as u } from "./payment-settlement-e8e799d8.js";
import { a as g, b as m } from "./payment-settlement-a7865af1.js";
import { ref as o } from "vue";
function h({ form: p = {} }) {
  const l = o([]), s = o([]), a = o([]), c = o([]);
  return { projectAllInfoData: l, projectList: s, supplierList: a, contractNoList: c, getProjectList: async (e) => {
    try {
      const t = await u(p.projectManagerId);
      l.value = t, t ? s.value = t.map((r) => r.project) : (i("warning", "该项目经理下暂无项目"), s.value = []);
    } catch (t) {
      console.log(t);
    }
  }, getSupplierList: async () => {
    try {
      const e = await g({});
      if (!e || Object.keys(e).length === 0) {
        i("warning", "暂无供应商"), a.value = [];
        return;
      }
      a.value = Object.entries(e).map(([t, r]) => ({ id: t, value: r }));
    } catch (e) {
      console.error("获取供应商失败:", e);
    }
  }, getContractNo: async (e) => {
    try {
      const t = await m({ supplierId: p.supplierId, ...e });
      t && Object.keys(t).length ? c.value = Object.entries(t).map(([r, n]) => ({ id: r, value: n })).sort((r, n) => Number(n.id) - Number(r.id)) : (i("warning", "该供应商下暂无合同号"), c.value = []);
    } catch (t) {
      console.log(t);
    }
  } };
}
export {
  h as u
};
