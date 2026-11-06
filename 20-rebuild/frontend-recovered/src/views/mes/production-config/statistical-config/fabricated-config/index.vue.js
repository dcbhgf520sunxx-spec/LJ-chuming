import { ref as g } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as k } from "vue";
import { unref as e } from "vue";
import { createBlock as m } from "vue";
import { withCtx as u } from "vue";
import { createVNode as o } from "vue";
import { createCommentVNode as C } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as R } from "element-plus";
import { l as s, x as P, pi as r, o as v, G as B, an as H, b as N } from "../../../../../shared/runtime.js";
import O from "./module/form.vue.js";
function S(a) {
  return s({ module: "mes", url: "fabricated", method: "get", params: a });
}
function A(a) {
  return s({ module: "mes", url: "fabricated", method: "put", data: a });
}
function E(a) {
  return s({ module: "mes", url: "fabricated", method: "delete", data: { auxiliaryId: a[0] } });
}
const I = { get: S, edit: A, del: E }, M = { class: "app-container" }, q = { __name: "index", setup(a) {
  const p = { add: false, edit: false, del: false, download: false }, d = g(), { crud: i, CRUD: f } = P({ title: "零件-栓钉套筒配置", sort: [], permission: { ...r }, optShow: { ...p }, crudApi: { ...I }, hasPagination: false }, d), { maxHeight: _ } = v();
  return f.HOOK.handleRefresh = (h, n) => {
    n.data.content = n.data.content.map((t) => (t.id = t.auxiliaryId, t));
  }, (h, n) => {
    const t = D, b = y("common-table"), x = R;
    return l(), w("div", M, [k((l(), m(b, { ref_key: "tableRef", ref: d, data: e(i).data, "empty-text": e(i).emptyText, "max-height": e(_), style: { width: "100%" } }, { default: u(() => [o(t, { label: "序号", type: "index", align: "center", width: "60" }), o(t, { prop: "auxiliaryName", label: "类别", align: "center" }), o(t, { prop: "unitPrice", label: "单价（元）", align: "center" }), e(B)([...e(r).edit, ...e(r).del]) ? (l(), m(t, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: u(({ row: { sourceRow: c } }) => [o(e(H), { data: c, disabledDel: e(N)(c.unitPrice) }, null, 8, ["data", "disabledDel"])]), _: 1 })) : C("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[x, e(i).loading]]), o(e(O))]);
  };
} };
export {
  q as default
};
