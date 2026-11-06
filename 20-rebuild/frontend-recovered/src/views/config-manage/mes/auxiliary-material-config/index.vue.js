import { ref as b } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as l } from "vue";
import { unref as a } from "vue";
import { withDirectives as I } from "vue";
import { createBlock as r } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as o } from "vue";
import { Fragment as A } from "vue";
import { renderList as E } from "vue";
import { toDisplayString as g } from "vue";
import { ElTableColumn as B } from "element-plus";
import { vLoading as M } from "element-plus";
import { l as c, _ as R, x as D, fi as f, o as P, am as V, fj as F, G as H, an as T, P as O } from "../../../../shared/runtime.js";
import $ from "./module/header.vue.js";
import j from "./module/form.vue.js";
function U(i) {
  return c({ module: "contract", url: "system/auxiliary-class", method: "get", params: i });
}
function q(i) {
  return c({ module: "contract", url: "system/auxiliary-class", method: "post", data: i });
}
function G(i) {
  return c({ module: "contract", url: "system/auxiliary-class", method: "put", data: i });
}
function K(i) {
  return c({ module: "contract", url: `system/auxiliary-class/delById/${i}`, method: "delete" });
}
const z = { get: U, add: q, edit: G, del: K };
const J = { class: "app-container" }, Q = { class: "head-container" }, W = { __name: "index", setup(i) {
  const v = { add: true, edit: false, del: false, download: false }, _ = b(), { CRUD: C, crud: m, columns: n } = D({ title: "配套件特征定义", sort: [], permission: { ...f }, optShow: { ...v }, crudApi: { ...z }, hasPagination: true }, _), { maxHeight: N } = P({ wrapperBox: ".auxiliaryMaterialConfig", paginate: true, extraHeight: 40 }), u = b([]);
  return C.HOOK.handleRefresh = (k, { data: h }) => {
    u.value = [], h.content.forEach((e) => {
      e.list = e.auxiliarySerialNumberList, e.classifyIds = e.boundFinalClassifyIds, e.classifyNames = e.classifyLinks.map((p) => p.classifyName).join("、"), e.basicClass = V.MATERIAL.V, u.value = u.value.concat(e.boundFinalClassifyIds);
    });
  }, (k, h) => {
    const e = B, p = S("common-table"), L = M;
    return t(), y("div", J, [w("div", Q, [l(a($))]), I((t(), r(p, { ref_key: "tableRef", ref: _, class: "upload-table", data: a(m).data, "empty-text": a(m).emptyText, "max-height": a(N), "return-source-data": "", showEmptySymbol: false, stripe: false, style: { width: "100%" } }, { default: d(() => [l(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(n).visible("name") ? (t(), r(e, { key: "name", prop: "name", align: "center", "show-overflow-tooltip": true, label: "类型名称", "min-width": "150" })) : o("", true), a(n).visible("classifyNames") ? (t(), r(e, { key: "classifyNames", prop: "classifyNames", "show-overflow-tooltip": true, label: "辅材科目", "min-width": "260" })) : o("", true), a(n).visible("auxiliarySerialNumberList") ? (t(), r(e, { key: "auxiliarySerialNumberList", prop: "auxiliarySerialNumberList", label: "编号", "show-overflow-tooltip": true, align: "center", "min-width": "260" }, { default: d((s) => [s.row.auxiliarySerialNumberList && s.row.auxiliarySerialNumberList.length > 0 ? (t(true), y(A, { key: 0 }, E(s.row.auxiliarySerialNumberList, (x) => (t(), y("span", { key: x.id }, g(`【${x.serialNumber}】`), 1))), 128)) : o("", true)]), _: 1 })) : o("", true), l(e, { key: "type", prop: "type", align: "center", "show-overflow-tooltip": true, label: "所属类型", width: "80" }, { default: d((s) => [w("span", null, g(s.row.type ? a(F).VL[s.row.type] : "-"), 1)]), _: 1 }), a(n).visible("sort") ? (t(), r(e, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", width: "80", align: "center" })) : o("", true), a(H)([...a(f).del, ...a(f).edit]) ? (t(), r(e, { key: 4, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: d((s) => [l(a(T), { data: s.row }, null, 8, ["data"])]), _: 1 })) : o("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[L, a(m).loading]]), l(a(O)), l(a(j), { boundAllClassifyIds: u.value }, null, 8, ["boundAllClassifyIds"])]);
  };
} }, ae = R(W, [["__scopeId", "data-v-c498cd08"]]);
export {
  ae as default
};
