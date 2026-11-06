import { ref as p } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as s } from "vue";
import { createBlock as i } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as S } from "vue";
import { toDisplayString as R } from "vue";
import { unref as e } from "vue";
import { createVNode as c } from "vue";
import { withDirectives as B } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElTableColumn as E } from "element-plus";
import { ElCard as H } from "element-plus";
import { vLoading as N } from "element-plus";
import { l as P, _ as T, x as V, o as q, P as A } from "../../../../shared/runtime.js";
import O from "./module/header.vue.js";
function U(l) {
  return P({ module: "system", url: "dict/page", method: "get", params: l });
}
const I = { get: U };
const K = { style: { "line-height": "28px" } }, L = { __name: "index", emits: ["click-line"], setup(l, { emit: u }) {
  const h = u, g = { get: ["systemDict:get"], editStatus: ["systemDict:editStatus"] }, f = { add: true, edit: false, del: true, download: false }, m = p(), x = p(), { crud: o, columns: d, CRUD: y } = V({ title: "字典列表", sort: [], permission: { ...g }, optShow: { ...f }, crudApi: { ...I }, hasPagination: true }, m, x), { maxHeight: b } = q({ wrapperBox: ".dict-box", paginate: true, extraHeight: 190 });
  function w(t) {
    t && h("click-line", t);
  }
  return y.HOOK.handleRefresh = (t, n) => (n.data.content.length > 0 && n.data.content.forEach((a) => {
    a.type = t.query.type;
  }), n), (t, n) => {
    const a = E, C = D("common-table"), v = H, k = N;
    return s(), i(v, { class: "line-box box-card" }, { header: r(() => [S("span", K, R(e(o).title), 1)]), default: r(() => [c(e(O)), B((s(), i(C, { ref_key: "tableRef", ref: m, "highlight-current-row": "", data: e(o).data, "empty-text": e(o).emptyText, "max-height": e(b), style: { width: "100%", "margin-top": "10px" }, onCurrentChange: w, "return-source-data": "", showEmptySymbol: false }, { default: r(() => [c(a, { label: "序号", type: "index", align: "center", width: "60" }), e(d).visible("name") ? (s(), i(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "140px" })) : _("", true), e(d).visible("remark") ? (s(), i(a, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "描述", "min-width": "140px" })) : _("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[k, e(o).loading]]), c(e(A))]), _: 1 });
  };
} }, z = T(L, [["__scopeId", "data-v-0c69a788"]]);
export {
  z as default
};
