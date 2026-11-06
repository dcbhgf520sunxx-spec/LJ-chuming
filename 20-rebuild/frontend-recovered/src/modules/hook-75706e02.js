import { e2 as p } from "../shared/runtime.js";
import { g as u, a as l, b as g } from "./payment-settlement-e8e799d8.js";
import { ref as c } from "vue";
function M({ form: t = {} }) {
  const i = c([]), o = c([]), s = c([]), n = c([]);
  return { projectAllInfoData: i, projectList: o, supplierList: s, contractNoList: n, getProjectList: async () => {
    try {
      const e = await u(t.projectManagerId);
      i.value = e, e ? o.value = e.map((r) => r.project) : (p("warning", "该项目经理下暂无项目"), o.value = []);
    } catch (e) {
      console.log(e);
    }
  }, getSupplierList: async () => {
    if (t.projectManagerId && t.projectId) try {
      const e = await l({ projectId: t.projectId, projectManagerId: t.projectManagerId });
      if (!e) {
        p("warning", "该项目下暂无供应商"), s.value = [];
        return;
      }
      s.value = Object.entries(e).map(([r, a]) => ({ id: r, value: a }));
    } catch (e) {
      console.error("获取供应商失败:", e);
    }
  }, getContractNo: async () => {
    if (t.projectManagerId && t.projectId && t.supplierId) try {
      const e = await g({ projectId: t.projectId, projectManagerId: t.projectManagerId, supplierId: t.supplierId });
      e && Object.keys(e).length ? n.value = Object.entries(e).map(([r, a]) => ({ id: Number(r), value: a })).sort((r, a) => a.id - r.id) : (p("warning", "该项目下暂无合同号"), n.value = []);
    } catch (e) {
      console.log(e);
    }
  } };
}
export {
  M as u
};
