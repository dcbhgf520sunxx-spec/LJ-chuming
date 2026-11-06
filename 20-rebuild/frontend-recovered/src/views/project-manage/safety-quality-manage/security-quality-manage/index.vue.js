import { computed as V } from "vue";
import { ref as h } from "vue";
import { watch as j } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as E } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as o } from "vue";
import { withCtx as f } from "vue";
import { createCommentVNode as l } from "vue";
import { createTextVNode as P } from "vue";
import { toDisplayString as q } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElTag as R } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as H, m as B } from "./module/detail.vue.js";
import { _ as Q, m as A, u8 as G, u9 as L, x as $, o as z, ua as I, G as F, P as J } from "../../../../shared/runtime.js";
import { J as _ } from "../../../../modules/project-19a12d6b.js";
import K from "./module/header.vue.js";
const W = { class: "app-container" }, X = { __name: "index", setup(Y) {
  const { globalProject: Z, globalProjectId: w } = A(["globalProject", "globalProjectId"]), k = { add: false, edit: false, del: false, download: false }, D = V(() => [["problemDate", ["parse-time", "{y}-{m}-{d}"]], ["problemDTO.penalty", ["to-thousand", 2]], ["type", ["parse-enum", G.ENUM]], ["isInternal", ["parse-enum", L.ENUM]]]), v = h(), g = h(false), x = h({}), { crud: n, CRUD: N, columns: r } = $({ title: "质安管理", sort: [], permission: { ..._ }, optShow: { ...k }, crudApi: { ...H }, requiredQuery: ["projectId"], hasPagination: true }, v);
  j(() => w.value, (p) => {
    p && (n.query.projectId = w.value, n.toQuery());
  }, { immediate: true, deep: true });
  const { maxHeight: T } = z({ paginate: true, extraHeight: 40 });
  function S(p) {
    x.value = p, g.value = true;
  }
  return N.HOOK.handleRefresh = (p, { data: c }) => {
    c.content.forEach((t) => {
      var u, d, b;
      t.beforeImgSrc = t.beforeChangeImgs && t.beforeChangeImgs.map((m) => m.imageUrl), t.afterImgSrc = ((u = t.qhseChange) == null ? void 0 : u.afterChangeImgs) && ((b = (d = t.qhseChange) == null ? void 0 : d.afterChangeImgs) == null ? void 0 : b.map((m) => m.imageUrl)), t.isInternal = Number(t.isInternal);
    });
  }, (p, c) => {
    const t = U, u = R, d = C("common-button"), b = C("common-table"), m = M;
    return a(), E("div", W, [i(e(K), { projectId: e(n).query.projectId }, null, 8, ["projectId"]), O((a(), o(b, { ref_key: "tableRef", ref: v, data: e(n).data, "data-format": D.value, "empty-text": e(n).emptyText, "max-height": e(T), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", stripe: false, showEmptySymbol: false }, { default: f(() => [i(t, { prop: "index", label: "序号", align: "center", width: "50", type: "index" }), e(r).visible("isInternal") ? (a(), o(t, { key: "isInternal", prop: "isInternal", label: "属性分类", align: "center", "show-overflow-tooltip": "" })) : l("", true), e(r).visible("type") ? (a(), o(t, { key: "type", prop: "type", label: "问题类别", align: "center", "show-overflow-tooltip": "" })) : l("", true), e(r).visible("problemDTO.name") ? (a(), o(t, { key: "problemDTO.name", prop: "problemDTO.name", label: "分类", align: "center", "show-overflow-tooltip": "" })) : l("", true), e(r).visible("supplierName") ? (a(), o(t, { key: "supplierName", prop: "supplierName", label: "责任单位", align: "center", "show-overflow-tooltip": "" })) : l("", true), e(r).visible("userName") ? (a(), o(t, { key: "userName", prop: "userName", label: "责任人", align: "center", "show-overflow-tooltip": "" })) : l("", true), e(r).visible("problemDTO.penalty") ? (a(), o(t, { key: "problemDTO.penalty", prop: "problemDTO.penalty", label: "处罚（元）", align: "center", "show-overflow-tooltip": "" })) : l("", true), e(r).visible("promoterName") ? (a(), o(t, { key: "promoterName", prop: "promoterName", label: "创建人", align: "center", "show-overflow-tooltip": "" })) : l("", true), e(r).visible("problemDate") ? (a(), o(t, { key: "problemDate", prop: "problemDate", label: "日期", align: "center", "show-overflow-tooltip": "" })) : l("", true), e(r).visible("boolChangeStatusV2") ? (a(), o(t, { key: "boolChangeStatusV2", prop: "boolChangeStatusV2", label: "状态", align: "center", width: "120" }, { default: f((s) => {
      var y;
      return [i(u, { type: (y = e(I).V[s.row.boolChangeStatusV2]) == null ? void 0 : y.T }, { default: f(() => [P(q(e(I).VL[s.row.boolChangeStatusV2]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : l("", true), e(F)(e(_).detail) ? (a(), o(t, { key: 9, label: "操作", width: "100", align: "center" }, { default: f((s) => [i(d, { icon: "el-icon-view", type: "primary", size: "default", onClick: (y) => S(s.row) }, null, 8, ["onClick"])]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[m, e(n).loading]]), i(e(B), { "detail-info": x.value, modelValue: g.value, "onUpdate:modelValue": c[0] || (c[0] = (s) => g.value = s), onSuccess: e(n).toQuery, permission: e(_) }, null, 8, ["detail-info", "modelValue", "onSuccess", "permission"]), i(e(J))]);
  };
} }, re = Q(X, [["__scopeId", "data-v-fd88514b"]]);
export {
  re as default
};
