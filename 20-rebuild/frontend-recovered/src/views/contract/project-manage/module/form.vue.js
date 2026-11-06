import { useStore as G } from "vuex";
import { ref as i } from "vue";
import { computed as w } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as d } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { unref as n } from "vue";
import { createTextVNode as T } from "vue";
import { createCommentVNode as M } from "vue";
import { withModifiers as U } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as p } from "vue";
import { createElementBlock as W } from "vue";
import { Fragment as Y } from "vue";
import { renderList as Q } from "vue";
import { withDirectives as N } from "vue";
import { vShow as S } from "vue";
import { ElStep as X } from "element-plus";
import { ElSteps as Z } from "element-plus";
import { ElForm as D } from "element-plus";
import { _ as ee, ao as te, kq as j, kr as se, ks as oe, G as re, gD as B, kt as ne } from "../../../../shared/runtime.js";
import ce from "./base-form.vue.js";
import ue from "./customer-form.vue.js";
import le from "./project-members.vue.js";
import ae from "./quoto-bid-contract-dialog.vue.js";
import "../../../../modules/dept-398bb184.js";
import "../../../../modules/region-cascader-39b54da2.js";
import "../../../../modules/tree-select-86c0f12c.js";
import "../../../../modules/win-bid-list-285b5b2e.js";
const me = { class: "demo-drawer__content" }, ie = { class: "form-content", style: { "padding-top": "20px" } }, pe = { __name: "form", props: { contractTypeInfo: { type: Object, default: () => {
} }, boolCanAdd: { type: Boolean, default: false }, permission: { type: Object, default: () => {
} } }, setup(v) {
  const c = v, h = G(), k = i(), F = i(), C = i(), R = i(), K = { baseRequestVO: {}, customer: {}, userIdList: [] }, { CRUD: O, crud: s, form: u } = te(K, k), P = { 0: { K: "baseFormRef", L: "基础信息", V: 0 }, 1: { K: "customerFormRef", L: "客户信息", V: 1 }, 2: { K: "projectMembersRef", L: "项目成员", V: 2 } }, r = i(0), _ = i(false), b = w(() => s.status.edit >= 1), z = w(() => {
    var e;
    return s.status.add >= 1 && ((e = c.contractTypeInfo) == null ? void 0 : e.contractType) !== j.MASTER_CONTRACT.V;
  }), I = i(false);
  function $() {
    switch (r.value) {
      case 0:
        return F.value.validateForm();
      case 1:
        return C.value.validateForm();
      case 2:
        return R.value.validateForm();
    }
  }
  async function A() {
    var e, t;
    try {
      if (await $()) {
        const a = s.form.baseRequestVO.projectAttribute;
        a === B.LUMP_SUM_SYSTEM.V || a === B.JOINT_VENTURE.V ? s.form.baseRequestVO.salesLeaderId = void 0 : s.form.baseRequestVO.projectManagerId = void 0, r.value === 2 ? (R.value.getCheckUser(), s.form.userIdList = R.value.checkUser || [], s.form.baseRequestVO.contractType = (e = c.contractTypeInfo) == null ? void 0 : e.contractType, s.status.add >= 1 && (s.form.baseRequestVO.projectId = (t = c.contractTypeInfo) == null ? void 0 : t.projectId), s.form.baseRequestVO.infoSourceName = void 0, s.submitCU()) : r.value++;
      }
    } catch (o) {
      console.log("error", o);
    }
  }
  O.HOOK.beforeToCU = (e, t) => {
    r.value = 0;
  }, O.HOOK.beforeToAdd = async (e, t) => {
    var o, a, V, g;
    if (((o = c.contractTypeInfo) == null ? void 0 : o.contractType) !== j.MASTER_CONTRACT.V && c.boolCanAdd) {
      const m = await se((a = c.contractTypeInfo) == null ? void 0 : a.projectId), q = await oe((V = c.contractTypeInfo) == null ? void 0 : V.projectId);
      const base = m.baseRequestVO;
      if (base.projectAttribute === B.SELF_SUPPORT.V && !base.salesLeaderId && base.projectManagerId) {
        base.salesLeaderId = base.projectManagerId;
      }
      m.baseRequestVO.oldSerialNumber = m.baseRequestVO.serialNumber, m.baseRequestVO.serialNumber = q, m.baseRequestVO.pid = (g = c.contractTypeInfo) == null ? void 0 : g.projectId, e.resetForm(JSON.parse(JSON.stringify(m))), E(t);
    }
  }, O.HOOK.beforeEditDetailLoaded = (e, t) => {
    E(t);
  };
  function E(e) {
    var t, o;
    e.baseRequestVO.region = [], e.baseRequestVO.countryId && e.baseRequestVO.region.push(e.baseRequestVO.countryId), e.baseRequestVO.provinceId && e.baseRequestVO.region.push(e.baseRequestVO.provinceId), e.baseRequestVO.cityId && e.baseRequestVO.region.push(e.baseRequestVO.cityId), e.baseRequestVO.regionId && e.baseRequestVO.region.push(e.baseRequestVO.regionId), (o = (t = e.baseRequestVO) == null ? void 0 : t.attachmentDTOList) != null && o.length ? e.baseRequestVO.attachmentFiles = e.baseRequestVO.attachmentDTOList : e.baseRequestVO.attachmentFiles = [], e.id = e.baseRequestVO.projectId;
  }
  async function H() {
    try {
      await h.dispatch("project/fetchUserProjects"), await h.dispatch("project/fetchProjectTree");
    } catch (e) {
      console.log(e);
    }
  }
  O.HOOK.afterAddSuccess = () => {
    H();
  };
  function J(e) {
    u.baseRequestVO = Object.assign(u.baseRequestVO, { name: e == null ? void 0 : e.projectName, region: e == null ? void 0 : e.regionIdList, shortName: e == null ? void 0 : e.projectShortName, contractAmount: e == null ? void 0 : e.contractAmount, taxRate: e == null ? void 0 : e.taxRate, startDate: e == null ? void 0 : e.startDate, endDate: e == null ? void 0 : e.endDate, commercialClause: e == null ? void 0 : e.paymentMethod, deptId: e == null ? void 0 : e.departId, deptName: e == null ? void 0 : e.departName, structureStatus: e == null ? void 0 : e.structureStatus, structureArea: e == null ? void 0 : e.quantity, unitType: ne.TONS.V }), u.customer = Object.assign(u.customer, { customerUnit: e == null ? void 0 : e.crmEnterpriseWarehousingName, receivingManager: e == null ? void 0 : e.partyAPersonName, receivingManagerPhone: e == null ? void 0 : e.partyAPhone });
  }
  return (e, t) => {
    var q;
    const o = L("common-button"), a = X, V = Z, g = D, m = L("common-drawer");
    return d(), y(m, { "append-to-body": true, "before-close": n(s).cancelCU, "close-on-click-modal": false, title: `合同立项${v.contractTypeInfo.contractType ? `【${n(j).VL[(q = v.contractTypeInfo) == null ? void 0 : q.contractType]}】` : ""}`, visible: n(s).status.cu > 0, direction: "rtl", size: "85%" }, { titleRight: l(() => [r.value === 0 && n(re)(v.permission.winningBid) ? (d(), y(o, { key: 0, disabled: _.value, type: "info", size: "default", onClick: t[0] || (t[0] = (f) => I.value = true) }, { default: l(() => t[3] || (t[3] = [T(" 引用中标合同 ")])), _: 1, __: [3] }, 8, ["disabled"])) : M("", true), r.value != 0 ? (d(), y(o, { key: 1, disabled: _.value, size: "default", type: "warning", onClick: t[1] || (t[1] = (f) => r.value--) }, { default: l(() => t[4] || (t[4] = [T(" 上一步 ")])), _: 1, __: [4] }, 8, ["disabled"])) : M("", true), r.value < 2 ? (d(), y(o, { key: 2, disabled: _.value, size: "default", type: "primary", onClick: U(A, ["stop"]) }, { default: l(() => t[5] || (t[5] = [T(" 下一步 ")])), _: 1, __: [5] }, 8, ["disabled"])) : (d(), y(o, { key: 3, loading: _.value, size: "default", type: "success", onClick: U(A, ["stop"]) }, { default: l(() => t[6] || (t[6] = [T("发起审批 ")])), _: 1, __: [6] }, 8, ["loading"]))]), content: l(() => [x("div", me, [p(V, { active: r.value, simple: "" }, { default: l(() => [(d(), W(Y, null, Q(P, (f) => p(a, { key: f.V, title: f.L, icon: "el-icon-edit" }, null, 8, ["title"])), 64))]), _: 1 }, 8, ["active"]), x("div", ie, [p(g, { ref_key: "formRef", ref: k, model: n(u) }, { default: l(() => [N(p(n(ce), { ref_key: "baseFormRef", ref: F, "form-data": n(u).baseRequestVO, isDisabledSN: z.value, isEdit: b.value }, null, 8, ["form-data", "isDisabledSN", "isEdit"]), [[S, r.value === 0]]), N(p(n(ue), { ref_key: "customerFormRef", ref: C, "form-data": n(u).customer }, null, 8, ["form-data"]), [[S, r.value === 1]]), N(p(n(le), { ref_key: "projectMembersRef", ref: R, "form-data": n(u).userIdList, isEdit: b.value }, null, 8, ["form-data", "isEdit"]), [[S, r.value === 2]])]), _: 1 }, 8, ["model"])])]), p(n(ae), { visible: I.value, "onUpdate:visible": t[2] || (t[2] = (f) => I.value = f), onRefresh: J }, null, 8, ["visible"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, Ie = ee(pe, [["__scopeId", "data-v-f8057a74"]]);
export {
  Ie as default
};
