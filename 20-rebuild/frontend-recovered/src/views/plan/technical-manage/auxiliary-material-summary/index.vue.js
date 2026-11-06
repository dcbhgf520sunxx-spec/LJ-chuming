import { ref as d } from "vue";
import { watch as v } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as u } from "vue";
import { unref as e } from "vue";
import { Fragment as w } from "vue";
import { createElementVNode as k } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as o } from "vue";
import { withCtx as j } from "vue";
import { createCommentVNode as r } from "vue";
import { ElTableColumn as q } from "element-plus";
import { vLoading as C } from "element-plus";
import { l as I, _ as M, m as A, x as B, o as D, D as S, P as R } from "../../../../shared/runtime.js";
import { A as T } from "../../../../modules/plan-d12d7ccf.js";
import E from "./module/header.vue.js";
function F(c) {
  return I({ module: "plan", url: "auxiliaryPart", method: "get", params: c });
}
const H = { get: F };
const N = { class: "app-container" }, V = { class: "head-container" }, L = { __name: "index", setup(c) {
  const { globalProject: _, globalProjectId: n } = A(["globalProject", "globalProjectId"]), f = { add: false, edit: false, del: false, download: false }, p = d(), { crud: l, columns: i } = B({ title: "配套件汇总", sort: ["id.asc"], permission: { ...T }, optShow: { ...f }, requiredQuery: ["projectId"], crudApi: { ...H }, hasPagination: true }, p), { maxHeight: g } = D({ wrapperBox: ".auxiliary-material-summary", paginate: true, extraHeight: 40 });
  v(() => n.value, (m) => {
    m && (l.query.projectId = n.value, l.toQuery());
  }, { immediate: true, deep: true });
  const h = d([["length", ["to-fixed", S.MES_ARTIFACT_L__MM]]]);
  return (m, Q) => {
    const a = q, y = x("common-table"), b = C;
    return t(), u("div", N, [e(_) ? (t(), u(w, { key: 0 }, [k("div", V, [s(e(E), { "project-id": e(n) }, null, 8, ["project-id"])]), P((t(), o(y, { ref_key: "tableRef", ref: p, data: e(l).data, "empty-text": e(l).emptyText, "max-height": e(g), "data-format": h.value, style: { width: "100%" } }, { default: j(() => [s(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(i).visible("name") ? (t(), o(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", align: "center" })) : r("", true), e(i).visible("length") ? (t(), o(a, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", align: "center" })) : r("", true), e(i).visible("material") ? (t(), o(a, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", align: "center" })) : r("", true), e(i).visible("specification") ? (t(), o(a, { key: "specification", prop: "specification", "show-overflow-tooltip": true, align: "center", label: "规格" })) : r("", true), e(i).visible("quantity") ? (t(), o(a, { key: "quantity", prop: "quantity", label: "数量", align: "center" })) : r("", true), e(i).visible("remark") ? (t(), o(a, { key: "remark", prop: "remark", "show-overflow-tooltip": true, align: "center", label: "备注" })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[b, e(l).loading]]), s(e(R))], 64)) : r("", true)]);
  };
} }, J = M(L, [["__scopeId", "data-v-f73064ef"]]);
export {
  J as default
};
