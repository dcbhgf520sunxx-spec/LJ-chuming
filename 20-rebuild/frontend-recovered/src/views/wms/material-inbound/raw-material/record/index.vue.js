import { ref as v } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as l } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as d } from "vue";
import { createTextVNode as c } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as D } from "vue";
import { renderList as P } from "vue";
import { ElTableColumn as A } from "element-plus";
import { ElTag as j } from "element-plus";
import { ElImage as I } from "element-plus";
import { vLoading as B } from "element-plus";
import { _ as F, uv as H, x as L, yz as z, xk as K, o as M, aR as O, k0 as N, w5 as g, an as G, P as $ } from "../../../../../shared/runtime.js";
import W from "./module/header.vue.js";
import J from "./module/detail.vue.js";
import Q from "./module/form.vue.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/index-e817c507.js";
import "../application/steel/index.vue.js";
import "../application/components/common-wrapper.vue.js";
import "../application/components/common-header.vue.js";
import "../application/components/common-footer.vue.js";
import "../application/components/confirm-dialog.vue.js";
import "../components/project-set-columns.vue.js";
import "../components/warehouse-set-columns.vue.js";
import "../application/steel/module/steel-plate-table.vue.js";
import "../../../../../modules/use-over-receive-ba08adae.js";
import "../application/components/inbound-quantity-column.vue.js";
import "../application/steel/module/section-steel-table.vue.js";
import "../application/steel/module/steel-coil-table.vue.js";
import "../application/auxiliary-material/index.vue.js";
import "../application/auxiliary-material/module/aux-mat-table.vue.js";
import "../application/other/index.vue.js";
import "../application/gas/index.vue.js";
import "../application/gas/module/gas-table.vue.js";
import "../../manufactured/index.vue.js";
import "../../manufactured/module/struc-manuf-table.vue.js";
import "../../manufactured/module/encl-manuf-table.vue.js";
const X = { class: "app-container" }, Y = { key: 0 }, Z = { class: "imgs-box" }, ee = { __name: "index", setup(te) {
  const x = { add: false, edit: false, del: false, download: false }, b = v([]), _ = v(), T = v([...H, ["qualityTestingTime", "parse-time"], ["approvalComments", "empty-text"]]), { crud: f, columns: o, CRUD: S } = L({ title: "入库记录", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime", "licensePlate", "shipmentNumber"], permission: { ...z }, optShow: { ...x }, crudApi: { ...K } }, _), { maxHeight: U } = M({ paginate: true });
  return S.HOOK.handleRefresh = async (C, { data: s }) => {
    s.content = s.content.map((i) => {
      var h;
      return i.imgUrls = ((h = i.attachments) == null ? void 0 : h.map((m) => m.imageUrl)) || [], i;
    });
  }, (C, s) => {
    const i = A, h = k("table-cell-tag"), m = j, E = I, R = k("common-table"), q = B;
    return a(), y("div", X, [n(e(W)), V((a(), l(R, { ref_key: "tableRef", ref: _, data: e(f).data, "data-format": T.value, "max-height": e(U), "default-expand-all": false, "expand-row-keys": b.value, "row-key": "id" }, { default: p(() => [n(O, { data: e(f).data, "expand-row-keys": b.value, "onUpdate:expandRowKeys": s[0] || (s[0] = (t) => b.value = t), "row-key": "id" }, { default: p(({ row: t }) => [d("p", null, [s[1] || (s[1] = c(" 关联项目：")), d("span", null, w(t.projectsFullName), 1)]), d("p", null, [s[2] || (s[2] = c(" 审批意见：")), d("span", null, w(t.approvalComments), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), n(i, { label: "序号", type: "index", align: "center", width: "60" }), e(o).visible("purchaseSN") ? (a(), l(i, { key: "purchaseSN", "show-overflow-tooltip": true, prop: "purchaseSN", label: "采购合同编号", "min-width": "155" }, { default: p(({ row: { sourceRow: t } }) => [n(h, { show: !!t.boolPartyA && !!t.purchaseSN, name: "甲供", type: "partyA", offset: 10 }, null, 8, ["show"]), t.purchaseSN ? (a(), y("span", Y, w(t.purchaseSN), 1)) : (a(), l(m, { key: 1, type: "danger", effect: "dark", size: "default" }, { default: p(() => s[3] || (s[3] = [c("甲供")])), _: 1, __: [3] }))]), _: 1 })) : r("", true), e(o).visible("serialNumber") ? (a(), l(i, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", "min-width": "160", label: "入库单号", align: "left" })) : r("", true), e(o).visible("licensePlate") ? (a(), l(i, { key: "licensePlate", "show-overflow-tooltip": true, prop: "licensePlate", label: "车牌/船牌号", align: "left", width: "100" })) : r("", true), e(o).visible("shipmentNumber") ? (a(), l(i, { key: "shipmentNumber", prop: "shipmentNumber", label: "物流单号", align: "left", "min-width": "150", "show-overflow-tooltip": "" })) : r("", true), e(o).visible("basicClass") ? (a(), l(i, { key: "basicClass", "show-overflow-tooltip": true, prop: "basicClass", label: "物料种类", width: "120" })) : r("", true), e(o).visible("projects") ? (a(), l(i, { "show-overflow-tooltip": "", key: "projects", prop: "projects", label: "关联项目", "min-width": "170" })) : r("", true), e(o).visible("supplier.name") ? (a(), l(i, { key: "supplier.name", "show-overflow-tooltip": true, prop: "supplier.name", label: "供应商", "min-width": "200" })) : r("", true), e(o).visible("attachments") ? (a(), l(i, { key: "attachments", prop: "attachments", "show-overflow-tooltip": false, label: "质检图片", width: "150px", align: "left" }, { default: p(({ row: { sourceRow: t } }) => [d("div", Z, [(a(true), y(D, null, P(t.attachments, (u) => (a(), l(E, { "preview-src-list": t.imgUrls, "initial-index": 1, key: u.id, src: u.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })) : r("", true), e(o).visible("applicantName") ? (a(), l(i, { key: "applicantName", "show-overflow-tooltip": true, prop: "applicantName", label: "申请人", align: "center", "min-width": "100" })) : r("", true), e(o).visible("editorName") ? (a(), l(i, { key: "editorName", "show-overflow-tooltip": true, prop: "editorName", label: "编辑人", align: "center", "min-width": "100" })) : r("", true), e(o).visible("qualityTestingUserName") ? (a(), l(i, { key: "qualityTestingUserName", "show-overflow-tooltip": true, prop: "qualityTestingUserName", label: "质检人", align: "center", "min-width": "100" })) : r("", true), e(o).visible("reviewerName") ? (a(), l(i, { key: "reviewerName", "show-overflow-tooltip": true, prop: "reviewerName", label: "审核人", align: "center", "min-width": "100" })) : r("", true), e(o).visible("createTime") ? (a(), l(i, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "申请时间", align: "center", width: "140" })) : r("", true), e(o).visible("qualityTestingTime") ? (a(), l(i, { key: "qualityTestingTime", "show-overflow-tooltip": true, prop: "qualityTestingTime", label: "质检时间", align: "center", width: "140" })) : r("", true), e(o).visible("userUpdateTime") ? (a(), l(i, { key: "userUpdateTime", "show-overflow-tooltip": true, prop: "userUpdateTime", label: "编辑时间", align: "center", width: "140" })) : r("", true), e(o).visible("reviewTime") ? (a(), l(i, { key: "reviewTime", "show-overflow-tooltip": true, prop: "reviewTime", label: "审核时间", align: "center", width: "140" })) : r("", true), e(o).visible("qualityTestingEnum") ? (a(), l(i, { key: "qualityTestingEnum", "show-overflow-tooltip": true, prop: "qualityTestingEnum", label: "质检状态", align: "center", width: "100", fixed: "right" }, { default: p(({ row: t }) => [n(m, { type: e(N).V[t == null ? void 0 : t.qualityTestingEnum].TAG }, { default: p(() => [c(w(e(N).V[t == null ? void 0 : t.qualityTestingEnum].SL), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : r("", true), e(o).visible("reviewStatus") ? (a(), l(i, { key: "reviewStatus", "show-overflow-tooltip": true, prop: "reviewStatus", label: "审核状态", align: "center", width: "80", fixed: "right" }, { default: p(({ row: t }) => {
      var u;
      return [n(m, { type: (u = e(g).V[t.reviewStatus]) == null ? void 0 : u.TAG }, { default: p(() => [c(w(e(g).VL[t.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : r("", true), n(i, { label: "操作", width: "170px", align: "center", fixed: "right" }, { default: p(({ row: t }) => [n(G, { "disabled-edit": !t.editable, "disabled-del": t.reviewStatus !== e(g).UNREVIEWED.V, data: t, "show-detail": "" }, null, 8, ["disabled-edit", "disabled-del", "data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])), [[q, e(f).loading]]), n(e($)), n(J), n(Q)]);
  };
} }, Ee = F(ee, [["__scopeId", "data-v-807d8a4c"]]);
export {
  Ee as default
};
