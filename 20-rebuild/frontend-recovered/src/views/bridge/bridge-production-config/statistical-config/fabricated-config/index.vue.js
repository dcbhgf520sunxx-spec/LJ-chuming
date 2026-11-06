import { ref as x } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as k } from "vue";
import { unref as e } from "vue";
import { createBlock as u } from "vue";
import { withCtx as f } from "vue";
import { createVNode as o } from "vue";
import { createCommentVNode as C } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as R } from "element-plus";
import { l, x as P, b5 as d, o as v, G as B, an as H, b as N } from "../../../../../shared/runtime.js";
import O from "./module/form.vue.js";
function S(t) {
  return l({ module: "bridge", url: "fabricated", method: "get", params: t });
}
function A(t) {
  return l({ module: "bridge", url: "fabricated", method: "put", data: t });
}
function E(t) {
  return l({ module: "bridge", url: "fabricated", method: "delete", data: { auxiliaryId: t[0] } });
}
const F = { get: S, edit: A, del: E }, I = { class: "app-container" }, V = { __name: "index", setup(t) {
  const p = { add: false, edit: false, del: false, download: false }, s = x(), { crud: i, CRUD: b } = P({ title: "零件-栓钉套筒配置", sort: [], permission: { ...d }, optShow: { ...p }, crudApi: { ...F }, hasPagination: false }, s), { maxHeight: h } = v();
  return b.HOOK.handleRefresh = (c, n) => {
    n.data.content = n.data.content.map((a) => (a.id = a.auxiliaryId, a));
  }, (c, n) => {
    const a = D, _ = y("common-table"), g = R;
    return r(), w("div", I, [k((r(), u(_, { ref_key: "tableRef", ref: s, data: e(i).data, "empty-text": e(i).emptyText, "data-format": c.columnsDataFormat, "max-height": e(h), style: { width: "100%" } }, { default: f(() => [o(a, { label: "序号", type: "index", align: "center", width: "60" }), o(a, { prop: "auxiliaryName", label: "类别", align: "center" }), o(a, { prop: "unitPrice", label: "单价（元）", align: "center" }), e(B)([...e(d).edit, ...e(d).del]) ? (r(), u(a, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: f(({ row: { sourceRow: m } }) => [o(e(H), { data: m, disabledDel: e(N)(m.unitPrice) }, null, 8, ["data", "disabledDel"])]), _: 1 })) : C("", true)]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height"])), [[g, e(i).loading]]), o(e(O))]);
  };
} };
export {
  V as default
};
