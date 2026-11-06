import { ref as U } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as C } from "vue";
import { withDirectives as k } from "vue";
import { unref as e } from "vue";
import { createBlock as u } from "vue";
import { withCtx as s } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as w } from "vue";
import { ElTableColumn as P } from "element-plus";
import { vLoading as T } from "element-plus";
import { l as _, x as v, pg as p, o as D, aT as c, G as S, an as N } from "../../../../../shared/runtime.js";
import V from "./module/form.vue.js";
function B(o) {
  return _({ module: "mes", url: "coating", method: "get", params: o });
}
function E(o) {
  return _({ module: "mes", url: "coating", method: "put", data: o });
}
const R = { get: B, edit: E }, $ = { class: "app-container" }, F = { __name: "index", setup(o) {
  const f = [["measureStr", ["parse-enum", c], { source: "measureUnit" }]], g = { add: false, edit: false, del: false, download: false }, m = U(), { crud: l } = v({ title: "涂装配置", sort: [], permission: { ...p }, optShow: { ...g }, crudApi: { ...R }, hasPagination: false }, m), { maxHeight: h } = D();
  return (A, H) => {
    const n = P, b = y("common-table"), x = T;
    return r(), C("div", $, [k((r(), u(b, { ref_key: "tableRef", ref: m, data: e(l).data, "empty-text": e(l).emptyText, "data-format": f, "max-height": e(h), style: { width: "100%" } }, { default: s(() => [a(n, { label: "序号", type: "index", align: "center", width: "60" }), a(n, { prop: "name", label: "油漆类别", align: "center" }), a(n, { prop: "measureStr", label: "计量方式", align: "center" }), a(n, { prop: "thickness", label: "标准涂装厚度（um）", align: "center" }), a(n, { prop: "unitPrice", label: "标准单价", align: "center" }, { default: s(({ row: t }) => [d("span", null, i(t.unitPrice) + " " + i(t.measureUnit ? `元/${e(c).V[t.measureUnit].C_UNIT}` : ""), 1)]), _: 1 }), a(n, { prop: "outThickness", label: "超标准设定（um）", align: "center" }), a(n, { prop: "outUnitPrice", label: "超标准单价", align: "center" }, { default: s(({ row: t }) => [d("span", null, i(t.outUnitPrice) + " " + i(t.measureUnit ? `元/${e(c).V[t.measureUnit].C_UNIT}` : ""), 1)]), _: 1 }), e(S)([...e(p).edit]) ? (r(), u(n, { key: 0, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: s((t) => [a(e(N), { data: t.row, showDel: false }, null, 8, ["data"])]), _: 1 })) : w("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[x, e(l).loading]]), a(e(V))]);
  };
} };
export {
  F as default
};
