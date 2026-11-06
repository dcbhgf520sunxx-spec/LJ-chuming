import { ref as c } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as e } from "vue";
import { unref as o } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as x } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as U } from "vue";
import { Fragment as V } from "vue";
import { renderList as q } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as O } from "vue";
import { ElTableColumn as S } from "element-plus";
import { ElImage as N } from "element-plus";
import { ElTag as B } from "element-plus";
import { vLoading as E } from "element-plus";
import { c as L, _ as z } from "./module/detail.vue.js";
import { _ as $, m as A, x as F, o as G, P as K, G as M } from "../../../../shared/runtime.js";
import { z as f } from "../../../../modules/project-19a12d6b.js";
import Q from "./module/header.vue.js";
import "../../../../modules/PicUpload-8580ccfc.js";
import "../../../../modules/subcontract-supplier-select-bab9e7f8.js";
const J = { class: "app-container" }, W = { class: "imgs-box" }, X = { __name: "index", setup(Y) {
  const { globalProjectId: g, globalProject: k } = A(["globalProjectId", "globalProject"]), P = { add: false, edit: false, del: false, download: false }, h = c(), p = c(false), b = c({}), { crud: l, CRUD: y } = F({ title: "问题记录", sort: ["id.desc"], permission: { ...f }, optShow: { ...P }, requiredQuery: ["projectId"], crudApi: { ...L }, hasPagination: true }, h);
  y.HOOK.beforeRefresh = () => (l.query.projectId = g.value || void 0, !!l.query.projectId);
  const j = c([["createTime", "parse-time"]]), { maxHeight: I } = G({ paginate: true, extraHeight: 40 });
  y.HOOK.handleRefresh = (m, i) => {
    var t;
    (t = i.data.content) == null || t.map((r) => {
      var n;
      return r.imgUrls = (n = r.attachmentDTOList) == null ? void 0 : n.map((u) => u.imageUrl), r;
    });
  };
  function T(m) {
    M(f.detail) && (b.value = m, p.value = true);
  }
  return (m, i) => {
    const t = S, r = N, n = B, u = v("common-button"), C = v("common-table"), D = E;
    return d(), w("div", J, [e(Q, { projectId: o(g) }, null, 8, ["projectId"]), R((d(), x(C, { ref_key: "tableRef", ref: h, data: o(l).data, "data-format": j.value, "empty-text": o(l).emptyText, "max-height": o(I), stripe: false, "row-key": "id", style: { width: "100%" } }, { default: s(() => [e(t, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), e(t, { key: "supplier.name", prop: "supplier.name", label: "供应商", align: "center", "show-overflow-tooltip": true }), e(t, { key: "licensePlate", prop: "licensePlate", label: "车牌/船牌号", align: "center", "show-overflow-tooltip": true }), e(t, { key: "userName", prop: "userName", label: "记录人", align: "center", "show-overflow-tooltip": true }), e(t, { key: "createTime", prop: "createTime", label: "日期", align: "center", "show-overflow-tooltip": true }), e(t, { key: "quantity", prop: "quantity", label: "图片", align: "center", "show-overflow-tooltip": true }, { default: s(({ row: a }) => [U("div", W, [(d(true), w(V, null, q(a.attachmentDTOList, (_) => (d(), x(r, { key: _.id, "preview-src-list": a.imgUrls, "initial-index": 1, src: _.imageUrl, "preview-teleported": "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 }), e(t, { key: "state", prop: "state", label: "状态", align: "center", "show-overflow-tooltip": true }, { default: s(({ row: a }) => [e(n, { type: a.state === 1 ? "success" : "danger", size: "default" }, { default: s(() => [H(O(a.state === 1 ? "已关闭" : "未关闭"), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), e(t, { label: "操作", width: "150px", align: "center", fixed: "right" }, { default: s((a) => [e(u, { size: "default", icon: "el-icon-view", type: "primary", onClick: (_) => T(a.row) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[D, o(l).loading]]), e(o(K)), e(z, { modelValue: p.value, "onUpdate:modelValue": i[0] || (i[0] = (a) => p.value = a), "detail-data": b.value, permission: o(f), globalProject: o(k), onSuccess: o(l).toQuery }, null, 8, ["modelValue", "detail-data", "permission", "globalProject", "onSuccess"])]);
  };
} }, se = $(X, [["__scopeId", "data-v-44eceb9d"]]);
export {
  se as default
};
