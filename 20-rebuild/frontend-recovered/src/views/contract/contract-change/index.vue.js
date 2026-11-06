import { ref as u } from "vue";
import { resolveComponent as A } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as V } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as p } from "vue";
import { unref as t } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as n } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as l } from "vue";
import { Fragment as H } from "vue";
import { normalizeClass as $ } from "vue";
import { ElTableColumn as G } from "element-plus";
import { vLoading as q } from "element-plus";
import { c as J, a as K } from "./module/contractInfo.vue.js";
import { j as k } from "../../../modules/contract-9b18cc88.js";
import { _ as W, t as X, x as Y, o as Z, z as ee, ir as y, p as R, bV as N, is as te, c3 as O, G as oe, P as ae } from "../../../shared/runtime.js";
import ie from "./module/header.vue.js";
import le from "../info/money-form.vue.js";
import re from "../info/variation-order.vue.js";
import ne from "../info/settle-form.vue.js";
import "./module/base.vue.js";
import "../../../modules/index-61ce89a1.js";
import "./module/business.vue.js";
import "./module/enclosure-show.vue.js";
import "./module/enclosure-table/sandwich-table.vue.js";
import "../../../modules/judgeSameValue-9683bdce.js";
import "./module/enclosure-table/pressed-color-table.vue.js";
import "./module/enclosure-table/pressed-support-table.vue.js";
import "./module/enclosure-table/structure-table.vue.js";
import "./module/enclosure-table/truss-support-table.vue.js";
import "./module/customer.vue.js";
import "./module/members.vue.js";
import "../info/components/user-dept-cascader.vue.js";
import "../../../modules/UploadBtn-b4cfb47a.js";
const se = { class: "app-container" }, ue = { class: "head-container" }, de = { key: 0 }, ce = { style: { width: "150px", "white-space": "nowrap", overflow: "hidden", "text-overflow": "ellipsis" } }, pe = { __name: "index", setup(me) {
  const U = { add: false, edit: false, del: false, download: false }, { decimalPrecision: g } = X(), T = u(), E = u(), f = u(), w = u("detail"), b = u(false), C = u(false), S = u(false), x = u(false), v = u({}), P = u(), _ = u(), { crud: m, columns: d } = Y({ title: "变更管理", sort: [], permission: { ...k }, optShow: { ...U }, crudApi: { ...J }, hasPagination: true }, T), { maxHeight: F } = Z({ wrapperBox: ".contractChange", paginate: true, extraHeight: 40 });
  function D(h, c) {
    switch (f.value = h.auditStatus, w.value = c, v.value = h, _.value = h.project.id, h.type) {
      case y.CONTRACT_AMOUNT.V:
        b.value = true;
        break;
      case y.CONTRACT_INFO.V:
        x.value = true;
        break;
    }
  }
  return (h, c) => {
    const r = G, I = A("common-button"), B = A("common-table"), M = Q("permission"), z = q;
    return o(), V("div", se, [a("div", ue, [p(t(ie))]), j((o(), n(B, { ref_key: "tableRef", ref: T, data: t(m).data, "empty-text": t(m).emptyText, "max-height": t(F), style: { width: "100%" }, "return-source-data": "", showEmptySymbol: false }, { default: s(() => [p(r, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(d).visible("project.shortName") ? (o(), n(r, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "项目", "min-width": "150" }, { default: s((e) => [a("span", null, i(t(ee)(e.row.project)), 1)]), _: 1 })) : l("", true), t(d).visible("type") ? (o(), n(r, { key: "type", prop: "type", "show-overflow-tooltip": true, label: "内容" }, { default: s((e) => [a("span", null, i(e.row.type ? t(y).VL[e.row.type] : ""), 1)]), _: 1 })) : l("", true), t(d).visible("changeDate") ? (o(), n(r, { key: "changeDate", prop: "changeDate", "show-overflow-tooltip": true, label: "变更日期", align: "center", width: "80" }, { default: s((e) => [a("div", null, i(e.row.changeDate ? t(R)(e.row.changeDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : l("", true), t(d).visible("userName") ? (o(), n(r, { key: "userName", prop: "userName", label: "发起人", align: "center", width: "90px", "show-overflow-tooltip": true }, { default: s((e) => [a("div", null, i(e.row.userName), 1)]), _: 1 })) : l("", true), t(d).visible("amount") ? (o(), n(r, { key: "amount", prop: "amount", "show-overflow-tooltip": true, label: "金额(元)", "min-width": "120" }, { default: s((e) => [e.row.type === t(y).CONTRACT_INFO.V ? (o(), V("span", de, i(t(N)(e.row.contractAmount, t(g).contract)), 1)) : l("", true), e.row.type === t(y).CONTRACT_AMOUNT.V ? (o(), V(H, { key: 1 }, [a("span", null, i(t(N)(e.row.contractAmount, t(g).contract)), 1), a("span", null, i(e.row.contractAmount < e.row.changeAmount ? "<" : ">"), 1), a("span", { class: $(e.row.contractAmount > e.row.changeAmount ? "tip-red" : "tip-green") }, i(t(N)(e.row.changeAmount, t(g).contract)), 3)], 64)) : l("", true)]), _: 1 })) : l("", true), t(d).visible("changeDesc") ? (o(), n(r, { key: "changeDesc", prop: "changeDesc", "show-overflow-tooltip": true, label: "变更描述", align: "center", width: "160" }, { default: s((e) => [a("div", ce, i(e.row.changeDesc ? e.row.changeDesc : "-"), 1)]), _: 1 })) : l("", true), t(d).visible("auditorName") ? (o(), n(r, { key: "auditorName", prop: "auditorName", label: "审核人", align: "center", width: "90px", "show-overflow-tooltip": true }, { default: s((e) => [a("div", null, i(e.row.auditorName), 1)]), _: 1 })) : l("", true), t(d).visible("auditTime") ? (o(), n(r, { key: "auditTime", prop: "auditTime", label: "审核日期", align: "center", width: "110px", "show-overflow-tooltip": true }, { default: s((e) => [a("div", null, i(e.row.auditTime ? t(R)(e.row.auditTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : l("", true), t(d).visible("source") ? (o(), n(r, { key: "source", prop: "source", label: "来源", align: "center", width: "90px", "show-overflow-tooltip": true }, { default: s((e) => [a("div", null, i(e.row.source ? t(te).VL[e.row.source] : ""), 1)]), _: 1 })) : l("", true), t(d).visible("auditStatus") ? (o(), n(r, { key: "auditStatus", prop: "auditStatus", label: "状态", align: "center", width: "90px" }, { default: s((e) => [a("div", null, i(e.row.auditStatus ? t(O).VL[e.row.auditStatus] : ""), 1)]), _: 1 })) : l("", true), p(r, { label: "操作", width: "130px", align: "center", fixed: "right" }, { default: s((e) => [j(p(I, { icon: "el-icon-view", type: "primary", size: "default", onClick: (L) => D(e.row, "detail") }, null, 8, ["onClick"]), [[M, t(k).detail]]), e.row.auditStatus == t(O).ENUM.AUDITING.V && t(oe)(t(k).audit) ? (o(), n(I, { key: 0, icon: "el-icon-stamp", type: "primary", size: "default", onClick: (L) => D(e.row, "audit") }, null, 8, ["onClick"])) : l("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[z, t(m).loading]]), p(t(ae)), p(t(le), { ref_key: "moneyRef", ref: E, "audit-status": f.value, "project-id": _.value, modelValue: b.value, "onUpdate:modelValue": c[0] || (c[0] = (e) => b.value = e), detailInfo: v.value, "show-type": w.value, onSuccess: t(m).toQuery }, null, 8, ["audit-status", "project-id", "modelValue", "detailInfo", "show-type", "onSuccess"]), p(t(re), { ref: "variationRef", "audit-status": f.value, "project-id": _.value, modelValue: C.value, "onUpdate:modelValue": c[1] || (c[1] = (e) => C.value = e), detailInfo: v.value, "show-type": w.value, onSuccess: t(m).toQuery }, null, 8, ["audit-status", "project-id", "modelValue", "detailInfo", "show-type", "onSuccess"]), p(t(ne), { ref: "settleRef", "audit-status": f.value, "project-id": _.value, modelValue: S.value, "onUpdate:modelValue": c[2] || (c[2] = (e) => S.value = e), detailInfo: v.value, "show-type": w.value, onSuccess: t(m).toQuery }, null, 8, ["audit-status", "project-id", "modelValue", "detailInfo", "show-type", "onSuccess"]), p(t(K), { ref_key: "contractInfoRef", ref: P, "audit-status": f.value, detailInfo: v.value, modelValue: x.value, "onUpdate:modelValue": c[3] || (c[3] = (e) => x.value = e), "show-type": w.value, onSuccess: t(m).toQuery }, null, 8, ["audit-status", "detailInfo", "modelValue", "show-type", "onSuccess"])]);
  };
} }, Pe = W(pe, [["__scopeId", "data-v-ea65554e"]]);
export {
  Pe as default
};
