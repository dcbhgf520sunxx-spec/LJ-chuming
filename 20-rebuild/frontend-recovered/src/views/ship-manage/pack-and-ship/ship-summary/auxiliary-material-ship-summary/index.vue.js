import { ref as p } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as u } from "vue";
import { unref as e } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as o } from "vue";
import { withCtx as k } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as j } from "vue";
import { ElTableColumn as L } from "element-plus";
import { vLoading as U } from "element-plus";
import { a as R } from "../../../../../modules/ship-summary-d5d4a58f.js";
import { k as B } from "../../../../../modules/ship-manage-3066b2ed.js";
import { x as N, o as V, P as H } from "../../../../../shared/runtime.js";
import P from "./module/header.vue.js";
import E from "./module/detail.vue.js";
const O = { class: "app-container" }, T = { class: "head-container" }, $ = ["onClick"], Q = { __name: "index", setup(q) {
  const _ = p([["project", "parse-project"]]), w = { add: false, edit: false, del: false, download: false }, f = p(), { crud: m, columns: i, CRUD: y } = N({ title: "配套制品", sort: [], permission: { ...B }, optShow: { ...w }, crudApi: { get: R } }, f), { maxHeight: x } = V({ paginate: true }), d = p(false), b = p([]);
  y.HOOK.handleRefresh = (s, l) => {
    l.data.content = l.data.content.map((t) => {
      var c;
      return t.packageStr = (c = t.packageList) == null ? void 0 : c.map((g) => g.serialNumber).join("、"), t;
    });
  };
  function C(s) {
    var l;
    (l = s.packageList) != null && l.length && (d.value = true, b.value = s.packageList);
  }
  return (s, l) => {
    const t = L, c = S("common-table"), g = U;
    return a(), D("div", O, [v("div", T, [u(e(P))]), M((a(), o(c, { ref_key: "tableRef", ref: f, data: e(m).data, "empty-text": e(m).emptyText, "max-height": e(x), "data-format": _.value, style: { width: "100%" } }, { default: k(() => [u(t, { label: "序号", type: "index", align: "center", width: "60" }), e(i).visible("project") ? (a(), o(t, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", align: "left" })) : r("", true), e(i).visible("name") ? (a(), o(t, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true, "min-width": "100px" })) : r("", true), e(i).visible("specification") ? (a(), o(t, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true, "min-width": "120px" })) : r("", true), e(i).visible("accountingUnit") ? (a(), o(t, { key: "accountingUnit", prop: "accountingUnit", label: "单位", align: "center", "show-overflow-tooltip": true })) : r("", true), e(i).visible("mete") ? (a(), o(t, { key: "mete", prop: "mete", label: "清单量", align: "center", "show-overflow-tooltip": true })) : r("", true), e(i).visible("cargoMete") ? (a(), o(t, { key: "cargoMete", prop: "cargoMete", label: "已发运", align: "center", "show-overflow-tooltip": true })) : r("", true), e(i).visible("unCargoMete") ? (a(), o(t, { key: "unCargoMete", prop: "unCargoMete", label: "未发运", align: "center", "show-overflow-tooltip": true })) : r("", true), e(i).visible("packageStr") ? (a(), o(t, { key: "packageStr", prop: "packageStr", label: "备注", align: "center", "show-overflow-tooltip": true }, { default: k(({ row: n }) => {
      var h;
      return [v("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: (A) => C(n) }, j((h = n.packageList) != null && h.length ? "包单号：" + n.packageStr : "-"), 9, $)];
    }), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[g, e(m).loading]]), u(e(H)), u(e(E), { visible: d.value, "onUpdate:visible": l[0] || (l[0] = (n) => d.value = n), "package-list": b.value }, null, 8, ["visible", "package-list"])]);
  };
} };
export {
  Q as default
};
