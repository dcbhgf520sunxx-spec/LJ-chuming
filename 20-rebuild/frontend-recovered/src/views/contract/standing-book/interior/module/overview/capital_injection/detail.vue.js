import { ref as i } from "vue";
import { inject as g } from "vue";
import { computed as j } from "vue";
import { watch as S } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as l } from "vue";
import { unref as n } from "vue";
import { createVNode as a } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as h } from "vue";
import { createBlock as A } from "vue";
import { withDirectives as I } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTable as F } from "element-plus";
import { ElDivider as R } from "element-plus";
import { vLoading as U } from "element-plus";
import { _ as T, x as E, D as P, bV as u } from "../../../../../../../shared/runtime.js";
import { a as q } from "../../../../../../../modules/index-1f7d934b.js";
import { g as V } from "../../../../../../../modules/capital-de0d42db.js";
const L = { class: "info box-container" }, O = { key: 0, class: "left" }, Q = { key: 0 }, Y = { key: 1 }, z = { key: 0 }, G = { key: 1 }, H = { class: "right" }, J = { __name: "detail", setup(K) {
  const y = i(), { crud: s } = E({ title: "注资明细", crudApi: { get: V }, queryOnPresenterCreated: false }, y), { projectId: b, projectAttribute: _ } = g("common"), p = i(), d = i();
  g("common").projectManagerName = j(() => p.value), g("common").contractSignBodyName = j(() => d.value), S(() => b.value, async (e) => {
    e && (s.query.projectId = e, s.toQuery(), await x());
  }, { immediate: true });
  const N = i([["assetInjectionTime", ["parse-time", "{y}-{d}-{m}"]], ["capitalContributorAmount", ["to-thousand", P.YUAN]]]), v = i();
  async function x() {
    try {
      const e = await q({ projectId: b.value });
      _.value === 2 ? (d.value = e.contractSignBodyName + (e.contractSignBodyRatio + "%"), p.value = e.projectManagerName + " " + (e.projectManagerRatio + "%")) : (d.value = e.contractSignBodyName, p.value = e.projectManagerName), e.contractSignBodyUseAmount = (parseFloat(e.contractSignBodyRemainAmount) - parseFloat(e.contractSignBodyPayAmount)).toFixed(2), e.projectManageUseAmount = (parseFloat(e.projectManagerRemainAmount) - parseFloat(e.projectManagerPayAmount)).toFixed(2), e.projectName = e.project.serialNumber + " - " + e.project.shortName, v.value = [e];
    } catch (e) {
      console.log(e, "获取注资信息失败");
    }
  }
  return (e, W) => {
    const t = M, B = F, C = R, k = D("common-table"), w = U;
    return r(), l("div", L, [n(_) === 2 ? (r(), l("div", O, [a(B, { data: v.value }, { default: c(() => [a(t, { label: d.value || "--", align: "center", prop: "" }, { default: c(() => [a(t, { align: "center", label: "已使用", prop: "contractSignBodyUseAmount" }, { default: c(({ row: { contractSignBodyPayAmount: o } }) => [f("span", null, m(n(u)(o)), 1)]), _: 1 }), a(t, { align: "center", label: "可用", prop: "contractSignBodyUseAmount" }, { default: c(({ row: { contractSignBodyUseAmount: o } }) => [o ? (r(), l("span", Q, m(n(u)(o)), 1)) : (r(), l("span", Y, "-"))]), _: 1 })]), _: 1 }, 8, ["label"]), a(t, { label: p.value || "--", align: "center", prop: "" }, { default: c(() => [a(t, { align: "center", label: "已使用", prop: "projectManageUseAmount" }, { default: c(({ row: { projectManagerPayAmount: o } }) => [f("span", null, m(n(u)(o)), 1)]), _: 1 }), a(t, { align: "center", label: "可用", prop: "projectManageUseAmount" }, { default: c(({ row: { projectManageUseAmount: o } }) => [o ? (r(), l("span", z, m(n(u)(o)), 1)) : (r(), l("span", G, "-"))]), _: 1 })]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["data"])])) : h("", true), n(_) === 2 ? (r(), A(C, { key: 1, class: "direction", direction: "vertical" })) : h("", true), f("div", H, [I((r(), A(k, { ref_key: "tableRef", ref: y, data: n(s).data, "data-format": N.value, "empty-text": n(s).emptyText }, { default: c(() => [a(t, { align: "center", label: "序号", type: "index", width: "60" }), a(t, { align: "center", label: "日期", prop: "assetInjectionTime" }), a(t, { align: "center", label: "注资人", prop: "capitalContributor.name" }), a(t, { align: "center", label: "金额", prop: "capitalContributorAmount" }), a(t, { align: "center", label: "类型", prop: "assetInjectionName" }), a(t, { align: "center", label: "创建人", prop: "creatorUser.name" })]), _: 1 }, 8, ["data", "data-format", "empty-text"])), [[w, n(s).loading]])])]);
  };
} }, ae = T(J, [["__scopeId", "data-v-87802086"]]);
export {
  ae as default
};
