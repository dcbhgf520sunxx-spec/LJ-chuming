import { ref as p } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as E } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as s } from "vue";
import { withCtx as n } from "vue";
import { createCommentVNode as u } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as b } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as P } from "element-plus";
import { vLoading as D } from "element-plus";
import { c as B } from "./module/print-header.vue.js";
import { kL as I, x as N, nR as Q, o as H, kC as U, kG as $, nS as v, P as A } from "../../../../shared/runtime.js";
import O from "./module/header.vue.js";
import q from "./module/print-drawer.vue.js";
import "../../../../modules/label-6ff6c88d.js";
import "../../../../modules/use-label-print-e19db37a.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
import "../../../../modules/index-069ba252.js";
import "../../../../modules/index-90569c81.js";
import "../../../../modules/index-3b2e6e51.js";
import "../components/task-printed-record-drawer.vue.js";
import "../../../../modules/one-code-number-list-af2f89eb.js";
import "../components/label-dlg.vue.js";
const F = { class: "app-container" }, G = { class: "head-container" }, de = { __name: "index", setup(K) {
  const g = p([["project", "parse-project"], ["createTime", ["parse-time", "{y}-{m}-{d}"]], ["handleMethod", ["parse-enum", I]]]), k = { add: false, edit: false, del: false, download: false }, f = p(), { crud: c, columns: w, CRUD: S } = N({ title: "返厂维修", sort: [], permission: { ...Q }, optShow: { ...k }, crudApi: { ...B } }, f), { maxHeight: x } = H({ paginate: true }), d = p(false), h = p({});
  function T(m) {
    d.value = true, h.value = m;
  }
  return S.HOOK.handleRefresh = (m, r) => {
    r.data.content = r.data.content.map((e) => {
      var i;
      return e.projectId = (i = e.project) == null ? void 0 : i.id, e;
    });
  }, (m, r) => {
    const e = M, i = P, C = _("common-button"), V = _("common-table"), R = D;
    return l(), j("div", F, [E("div", G, [a(o(O))]), L((l(), s(V, { ref_key: "tableRef", ref: f, data: o(c).data, "empty-text": o(c).emptyText, "max-height": o(x), "data-format": g.value, style: { width: "100%" } }, { default: n(() => [a(e, { label: "序号", type: "index", align: "center", width: "60" }), o(w).visible("project") ? (l(), s(e, { key: 0, prop: "project", "show-overflow-tooltip": true, label: "所属项目", "min-width": "160px" })) : u("", true), a(e, { "show-overflow-tooltip": "", prop: "productType", key: "productType", label: "制成品类型", align: "center", "min-width": "100" }, { default: n(({ row: t }) => [t.productType ? (l(), s(i, { key: 0, effect: "plain" }, { default: n(() => [y(b(t.relationType ? o(U).VL[t.relationType] : o($).VL[t.productType]), 1)]), _: 2 }, 1024)) : u("", true)]), _: 1 }), a(e, { "show-overflow-tooltip": "", prop: "handleMethod", key: "handleMethod", label: "处理方式", align: "center" }), a(e, { "show-overflow-tooltip": "", prop: "returnQuantity", key: "returnQuantity", label: "返厂件数", align: "center" }), a(e, { "show-overflow-tooltip": "", prop: "shipQuantity", key: "shipQuantity", label: "已发运件数", align: "center" }), a(e, { "show-overflow-tooltip": "", prop: "returnShipStatus", key: "returnShipStatus", label: "状态", align: "center" }, { default: n(({ row: t }) => [t.returnShipStatus ? (l(), s(i, { key: 0, effect: "plain", type: o(v).V[t.returnShipStatus].T }, { default: n(() => [y(b(o(v).VL[t.returnShipStatus]), 1)]), _: 2 }, 1032, ["type"])) : u("", true)]), _: 1 }), a(e, { label: "操作", align: "center", width: "90" }, { default: n(({ row: t }) => [a(C, { type: "primary", icon: "el-icon-view", onClick: (z) => T(t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[R, o(c).loading]]), a(o(A)), a(q, { visible: d.value, "onUpdate:visible": r[0] || (r[0] = (t) => d.value = t), detailInfo: h.value }, null, 8, ["visible", "detailInfo"])]);
  };
} };
export {
  de as default
};
