import { ref as p } from "vue";
import { inject as O } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as r } from "vue";
import { withCtx as m } from "vue";
import { unref as e } from "vue";
import { createElementVNode as M } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as a } from "vue";
import { createCommentVNode as n } from "vue";
import { toDisplayString as $ } from "vue";
import { ElTableColumn as z } from "element-plus";
import { ElPopconfirm as F } from "element-plus";
import { vLoading as G } from "element-plus";
import { x as W, o as J, E as K, dp as Q, G as x, eb as X, ec as Y, e2 as Z } from "../../../../../../../shared/runtime.js";
import { W as T } from "../../../../../../../modules/contract-9b18cc88.js";
import { u as ee } from "../../../../../../../modules/useTableTotal-3d22365a.js";
import { g as te, d as ae } from "../../../../../../../modules/capital-de0d42db.js";
import oe from "../components/establish/capital.vue.js";
import "../../../../../../../modules/data-039b7fd9.js";
const ne = { class: "classify-container" }, ie = { class: "table-container" }, re = { key: 0 }, se = { key: 1 }, be = { __name: "ClassifyTable", props: { form: Object, columns: Object, tableRef: Object }, setup(N, { expose: R }) {
  const U = { add: false, edit: false, del: false, download: false }, v = p(), { columns: s } = W({ title: "资金明细", invisibleColumns: ["updateTime", "putUserName"], optShow: { ...U }, hasPagination: false }, v), d = N, f = p(false), b = p(false), { _commonFn: g, projectInfo: C } = O("parent_data"), h = p([]), { requestData: w, total: k, getSummaries: A } = ee(false, { defineData: ["capitalContributorAmount"] }), u = async () => {
    try {
      b.value = true;
      const { totalElements: i, content: c } = await te({ ...w, ...d.form, projectId: C.project.id });
      k.value = i, h.value = Y(c, [], true);
    } catch (i) {
      console.error("获取注资列表失败", i);
    } finally {
      b.value = false;
    }
  };
  g.value.getCapitalList = u;
  const B = async (i) => {
    try {
      await ae(i.id), Z("success", "删除成功"), await u(), await g.value.getItemRegisterInfo(), await g.value.getProjectSum();
    } catch (c) {
      console.error("删除注资失败", c);
    }
  }, I = p(), D = async (i) => {
    await I.value.getCapitalItemInfo(i), f.value = true;
  }, { maxHeight: S } = J({ wrapperBox: ".classify-container", extraBox: ".header-container", paginate: true, extraHeight: 200 });
  return R({ getCapitalList: u, tableData: h }), (i, c) => {
    const P = _("print-table"), o = z, j = _("common-button"), E = F, H = _("common-table"), L = G;
    return t(), y("div", ne, [r(Q, { "header-title": "" }, { headerRight: m(() => [r(e(K), { showRefresh: false, showSearch: false }, { optLeft: m(() => [r(P, { params: { projectId: e(C).project.id, supplierId: d.form.projectManagerId || d.form.contractSignBodyId }, "api-key": "capitalInjection", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"])]), _: 1 })]), _: 1 }), M("div", ie, [V((t(), a(H, { ref_key: "tableRef", ref: v, data: h.value, "max-height": e(S), "summary-method": e(A), border: "", "show-summary": "", stripe: "" }, { default: m(() => [r(o, { align: "center", label: "序号", type: "index", width: "60" }), e(s).visible("assetInjectionTime") ? (t(), a(o, { key: "assetInjectionTime", align: "center", label: "创建日期", "min-width": "160", prop: "assetInjectionTime" })) : n("", true), e(s).visible("updateTime") ? (t(), a(o, { key: "updateTime", align: "center", label: "修改日期", "min-width": "160", prop: "updateTime" }, { default: m(({ row: { updateTime: l } }) => [l ? (t(), y("span", re, $(l), 1)) : (t(), y("span", se, "-"))]), _: 1 })) : n("", true), e(s).visible("capitalContributor.name") ? (t(), a(o, { key: "capitalContributor.name", align: "center", label: "注资方", "min-width": "240", prop: "capitalContributor.name" })) : n("", true), e(s).visible("assetInjectionName") ? (t(), a(o, { key: "assetInjectionName", align: "center", label: "注资类型", "min-width": "100", prop: "assetInjectionName" })) : n("", true), e(s).visible("capitalContributorAmount") ? (t(), a(o, { key: "capitalContributorAmount", align: "center", label: "金额", "min-width": "140", prop: "capitalContributorAmount" })) : n("", true), e(s).visible("creatorUser.name") ? (t(), a(o, { key: "creatorUser.name", align: "center", label: "创建人", "min-width": "120", prop: "creatorUser.name" })) : n("", true), e(s).visible("putUserName") ? (t(), a(o, { key: "putUserName", align: "center", label: "最后编辑人", "min-width": "120", prop: "putUserName" })) : n("", true), r(o, { align: "center", fixed: "right", label: "操作", width: "120" }, { default: m(({ row: l }) => [e(x)(e(T).innerPackAge.register.edit) ? (t(), a(j, { key: 0, icon: "el-icon-edit", type: "primary", onClick: (q) => D(l.id) }, null, 8, ["onClick"])) : n("", true), e(x)(e(T).innerPackAge.register.del) ? (t(), a(E, { key: 1, title: "确认是否删除吗?", onConfirm: (q) => B(l) }, { reference: m(() => [r(j, { icon: "el-icon-delete", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : n("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[L, b.value]])]), r(X, { "request-data": e(w), total: e(k), onHandleChange: u }, null, 8, ["request-data", "total"]), r(oe, { ref_key: "capitalRef", ref: I, visible: f.value, "onUpdate:visible": c[0] || (c[0] = (l) => f.value = l) }, null, 8, ["visible"])]);
  };
} };
export {
  be as default
};
