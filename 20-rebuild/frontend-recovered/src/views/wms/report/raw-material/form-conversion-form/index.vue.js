import { ref as d } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as j } from "vue";
import { unref as a } from "vue";
import { createBlock as o } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as y } from "vue";
import { toDisplayString as B } from "vue";
import { createCommentVNode as r } from "vue";
import { ElTableColumn as R } from "element-plus";
import { vLoading as D } from "element-plus";
import { x as O, BG as u, BH as S, cP as E, o as P, z as T, G as H, an as V, P as F, BI as A } from "../../../../../shared/runtime.js";
import G from "./module/header.vue.js";
const L = { class: "app-container" }, z = { __name: "index", setup(M) {
  const _ = { add: false, edit: false, del: false, download: false }, w = d(), { CRUD: v, crud: h, columns: i } = O({ title: "形态转换单", sort: ["id.desc"], permission: { ...u }, optShow: { ..._ }, crudApi: { ...S } }, w), g = d([["reviewTime", "parse-time"], ["basicClass", ["parse-enum", E, { f: "L" }]]]), { maxHeight: N } = P({ paginate: true }), f = d({});
  v.HOOK.handleRefresh = (c, { data: b }) => {
    b.content.forEach((e) => {
      var l;
      e.projectNames = [], (l = e.projects) == null || l.forEach((m) => {
        e.projectNames.push(T(m));
      }), e.projectNames = e.projectNames.join(",");
    });
  };
  function k(c) {
    f.value = c;
  }
  return (c, b) => {
    const e = R, l = C("common-table"), m = D;
    return t(), x("div", L, [s(G), j((t(), o(l, { ref_key: "tableRef", ref: w, data: a(h).data, "data-format": g.value, "max-height": a(N), "highlight-current-row": "" }, { default: p(() => [s(e, { align: "center", label: "序号", type: "index", width: "55" }, { default: p(({ $index: n }) => [y("span", null, B(n + 1), 1)]), _: 1 }), a(i).visible("reviewTime") ? (t(), o(e, { key: "reviewTime", align: "center", label: "转换时间", "min-width": "100", prop: "reviewTime", "show-overflow-tooltip": "" })) : r("", true), a(i).visible("receiptSerialNumber") ? (t(), o(e, { key: "receiptSerialNumber", align: "center", label: "形态转换单号", "min-width": "150", prop: "receiptSerialNumber", "show-overflow-tooltip": "" })) : r("", true), a(i).visible("basicClass") ? (t(), o(e, { key: "basicClass", align: "center", label: "物料种类", "min-width": "80", prop: "basicClass", "show-overflow-tooltip": "" })) : r("", true), a(i).visible("projectNames") ? (t(), o(e, { key: "projectNames", align: "center", label: "所属项目", "min-width": "200", prop: "projectNames", "show-overflow-tooltip": "" })) : r("", true), a(i).visible("taskOrderNumber") ? (t(), o(e, { key: "taskOrderNumber", align: "center", label: "工单号", "min-width": "150", prop: "taskOrderNumber", "show-overflow-tooltip": "" })) : r("", true), a(i).visible("reviewerName") ? (t(), o(e, { key: "reviewerName", align: "center", label: "办理人", "min-width": "100", prop: "reviewerName", "show-overflow-tooltip": "" })) : r("", true), a(H)([...a(u).detail]) ? (t(), o(e, { key: 6, align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: { sourceRow: n } }) => [s(V, { "before-to-detail": k, data: { ...n, id: n.id }, permission: a(u), "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data", "permission"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[m, a(h).loading]]), s(F), s(A, { "row-detail": f.value }, null, 8, ["row-detail"])]);
  };
} };
export {
  z as default
};
