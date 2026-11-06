import { ref as r } from "vue";
import { provide as h } from "vue";
import { computed as N } from "vue";
import { resolveComponent as P } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as l } from "vue";
import { createElementVNode as J } from "vue";
import { createVNode as v } from "vue";
import { withCtx as d } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as c } from "vue";
import { createTextVNode as V } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as y } from "vue";
import { Fragment as j } from "vue";
import { renderList as q } from "vue";
import { toDisplayString as W } from "vue";
import { ElTableColumn as X } from "element-plus";
import { vLoading as Y } from "element-plus";
import { c as Z, m as ee } from "./module/form.vue.js";
import { a as te, b as oe } from "../../../../modules/common-f216149e.js";
import { u as B } from "../../../../modules/contract-9b18cc88.js";
import { t as ae, fg as ne, g8 as se, x as re, o as ie, bV as le } from "../../../../shared/runtime.js";
import ce from "./module/header.vue.js";
import ue from "./module/detail.vue.js";
import "../../../../modules/UploadBtn-b4cfb47a.js";
const de = { class: "app-container" }, me = { class: "head-container" }, pe = { key: 0 }, fe = { key: 0 }, he = { key: 1 }, je = { __name: "index", setup(ve) {
  const { decimalPrecision: T } = ae(), { projectTree: S } = ne(), C = r(), R = r({}), b = r(false), U = se(["testing_fee_type"]), g = r(), A = r([]), D = r();
  for (let t = 1; t <= 12; t++) A.value.push(t);
  const $ = { add: false, edit: false, del: false, download: false }, w = r(false), H = r({}), F = r("addBtn"), { crud: i, CRUD: Q, columns: x } = re({ title: "检测费", sort: [], optShow: { ...$ }, permission: { ...B }, crudApi: { ...Z }, requiredQuery: ["year"], hasPagination: false }, C);
  h("dict", U), h("crud", i), h("branchList", g);
  const z = N(() => [["project", "parse-project"], ["totalAmount", ["to-thousand", T.value.contract]]]), { maxHeight: E } = ie({ extraBox: [".head-container"], paginate: true }), I = N(() => S.value.map((e) => (e.serialNumberName = e.serialNumber + " " + e.name, e)));
  h("projectList", I), h("BranchProjectList", D);
  function M(t) {
    b.value = true, R.value = t.sourceRow;
  }
  Q.HOOK.handleRefresh = (t, e) => {
    var m;
    e.data.content = (m = e.data.content) == null ? void 0 : m.map((s) => {
      var _;
      return s.totalAmount = (_ = s.testingFeeList) == null ? void 0 : _.reduce((p, u) => u ? p + (u == null ? void 0 : u.feeAmount) : p, 0), s;
    });
  };
  async function O() {
    try {
      const { content: t } = await te();
      g.value = t;
    } catch (t) {
      console.log(t);
    }
  }
  O();
  async function K() {
    try {
      const t = await oe();
      D.value = t;
    } catch (t) {
      console.log(t);
    }
  }
  return K(), (t, e) => {
    const m = P("common-button"), s = X, _ = P("common-table"), p = G("permission"), u = Y;
    return o(), l("div", de, [J("div", me, [v(ce, { ref: "headerRef", branchList: g.value }, { btn: d(() => [k((o(), c(m, { class: "filter-item", icon: "el-icon-plus", size: "default", type: "primary", onClick: e[0] || (e[0] = (n) => {
      F.value = "addBtn", w.value = true;
    }) }, { default: d(() => e[3] || (e[3] = [V(" 新增 ")])), _: 1, __: [3] })), [[p, a(B).add]])]), _: 1 }, 8, ["branchList"])]), k((o(), c(_, { ref_key: "tableRef", ref: C, data: a(i).data, "data-format": z.value, "empty-text": a(i).emptyText, "max-height": a(E), style: { width: "100%" } }, { default: d(() => [v(s, { align: "center", label: "序号", prop: "index", type: "index", width: "60px" }), a(x).visible("project") ? (o(), c(s, { key: "project", "show-overflow-tooltip": true, align: "center", label: "项目", "min-width": "200px", prop: "project" })) : y("", true), a(x).visible("testingFeeTypeName") ? (o(), c(s, { key: "testingFeeTypeName", "show-overflow-tooltip": true, align: "center", label: "检测费类别", prop: "testingFeeTypeName", width: "120px" })) : y("", true), (o(true), l(j, null, q(A.value, (n) => (o(), c(s, { key: n, label: n.toString() + "月", "show-overflow-tooltip": true, align: "center", prop: "feeAmount" }, { default: d((L) => [L.row.testingFeeList.findIndex((f) => f.month == n) > -1 ? (o(), l("div", pe, [(o(true), l(j, null, q(L.row.testingFeeList, (f) => (o(), l(j, { key: f }, [f.month == n ? (o(), l("span", fe, W(a(le)(f.feeAmount, a(T).contract)), 1)) : y("", true)], 64))), 128))])) : (o(), l("span", he, "/"))]), _: 2 }, 1032, ["label"]))), 128)), a(x).visible("totalAmount") ? (o(), c(s, { key: "totalAmount", "show-overflow-tooltip": true, align: "center", label: "合计", prop: "totalAmount" })) : y("", true), v(s, { align: "center", label: "操作", width: "120px" }, { default: d((n) => [k((o(), c(m, { size: "default", type: "primary", onClick: (L) => M(n.row) }, { default: d(() => e[4] || (e[4] = [V("查看")])), _: 2, __: [4] }, 1032, ["onClick"])), [[p, a(B).detail]])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[u, a(i).loading]]), v(ee, { visible: w.value, "onUpdate:visible": e[1] || (e[1] = (n) => w.value = n), info: H.value, showType: F.value, onRefresh: a(i).toQuery }, null, 8, ["visible", "info", "showType", "onRefresh"]), v(ue, { visible: b.value, "onUpdate:visible": e[2] || (e[2] = (n) => b.value = n), "detail-data": R.value, query: a(i).query, onRefresh: a(i).toQuery }, null, 8, ["visible", "detail-data", "query", "onRefresh"])]);
  };
} };
export {
  je as default
};
