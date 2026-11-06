import { ref as n } from "vue";
import { inject as N } from "vue";
import { watch as H } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as i } from "vue";
import { normalizeClass as I } from "vue";
import { unref as s } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as G } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as k } from "vue";
import { createTextVNode as M } from "vue";
import { ElAlert as O } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { ElTag as F } from "element-plus";
import { ElTable as J } from "element-plus";
import { vLoading as W } from "element-plus";
import { C as $ } from "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import { _ as K, o as Q, k_ as U, c1 as T, eb as X, G as Y, e2 as Z, k$ as ee, dq as C, ec as te, l0 as ae } from "../../../../../shared/runtime.js";
import { u as oe } from "../../../../../modules/useTableTotal-3d22365a.js";
import { W as se } from "../../../../../modules/contract-9b18cc88.js";
const le = { class: "table-container" }, ne = { key: 0, style: { width: "100%" } }, re = { key: 1 }, ce = { class: "header-box" }, ie = { class: "main-box" }, ue = { __name: "table", setup(de, { expose: E }) {
  const { maxHeight: L } = Q({ paginate: true, mainBox: [".app-container", ".card-container"], wrapperBox: [], extraBox: [".header-box", ".head-container"], extraHeight: "40" }), d = n(), l = n([]), p = n(false), _ = n(null), m = n(true), { requestData: g, total: w } = oe(), A = N("parent_data"), { formData: x, projectInfo: P, particularsRef: y, _commonFn: j } = A, v = async () => {
    if (!Y(se.innerPackAge.get)) return Z("warning", "暂无权限");
    try {
      p.value = true;
      const { totalElements: e, content: a } = await ee(C({ ...g, ...x }));
      l.value = te(a), l.value.forEach((h, o) => {
        h.rowIndex = o;
      }), w.value = e, await b(), m.value = false;
    } catch (e) {
      console.error("获取项目台账表格数据失败:", e);
    } finally {
      p.value = false;
    }
  }, b = async () => {
    try {
      d.value = await ae(C({ ...g, ...x }));
    } catch (e) {
      console.error("获取总结余失败:", e);
    }
  };
  j.value.getProjectSum = b, j.value.getTableList = v;
  const V = (e) => {
    _.value = e.rowIndex;
    const { projectLedgerDTO: a } = e;
    Object.assign(P, a), y.value.drawerVisible = true;
  }, B = ({ row: e, rowIndex: a }) => _.value === a ? "selected-row" : "";
  return H(l, (e) => {
    _.value = "", y.value.drawerVisible = false;
  }), E({ tableList: l, getTableList: v, isShowAlert: m, getProjectSum: b }), (e, a) => {
    const h = O, o = z, S = F, D = J, q = W;
    return c(), f("div", le, [m.value ? (c(), f("div", ne, [t(h, { closable: false, description: "项目可选择所有项目以及该项目经理下所属项目", "show-icon": "", title: "根据选项进行项目搜索", type: "info" })])) : (c(), f("div", re, [i("div", ce, [a[0] || (a[0] = i("div", null, "总结余", -1)), t(s($), { class: I([0 <= d.value ? "greenColor" : "redColor", "card-panel-num"]), decimals: 2, duration: 1e3, "end-val": d.value || 0, "start-val": 0 }, null, 8, ["class", "end-val"])]), i("div", ie, [R((c(), G(D, { data: l.value, "max-height": s(L), "row-class-name": B, border: "", "element-loading-text": "数据正在加载中...", style: { cursor: "pointer" }, onRowClick: V }, { default: u(() => [t(o, { align: "center", label: "序号", type: "index", width: "50" }), t(o, { align: "center", label: "立项日期", prop: "createTime", width: "100" }), t(o, { align: "center", label: "项目", "min-width": "180", prop: "projectName", "show-overflow-tooltip": "" }), t(o, { align: "center", label: "类型", prop: "projectAttribute", width: "60" }, { default: u(({ row: r }) => [i("span", null, k(s(U).VL[r.projectAttribute]), 1)]), _: 1 }), t(o, { align: "center", label: "状态", prop: "status", width: "80" }, { default: u(({ row: r }) => [t(S, { type: s(T).V[r.status].TAG }, { default: u(() => [M(k(s(T).VL[r.status]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[q, p.value]]), t(X, { "request-data": s(g), total: s(w), onHandleChange: v }, null, 8, ["request-data", "total"])])]))]);
  };
} }, be = K(ue, [["__scopeId", "data-v-9eb97793"]]);
export {
  be as default
};
