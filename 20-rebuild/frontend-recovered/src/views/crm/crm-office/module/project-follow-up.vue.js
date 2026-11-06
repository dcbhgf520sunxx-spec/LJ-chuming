import { useStore as pe } from "vuex";
import { computed as Ne } from "vue";
import { ref as u } from "vue";
import { watch as ge } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as P } from "vue";
import { withCtx as C } from "vue";
import { unref as m } from "vue";
import { createTextVNode as x } from "vue";
import { createCommentVNode as K } from "vue";
import { createVNode as D } from "vue";
import { withModifiers as Ie } from "vue";
import { createElementVNode as be } from "vue";
import { createElementBlock as we } from "vue";
import { ElMessage as j } from "element-plus";
import { ElTag as Te } from "element-plus";
import { m as he, u as ye, bv as Ve, dA as t, lI as _e, lv as M, R as Ce, S as Ee, p as Re } from "../../../../shared/runtime.js";
import { f as Ae, j as Oe, k as Ue, l as Fe, t as ke, m as Pe } from "../../../../modules/project-information-053c195b.js";
import { a as De } from "../../../../modules/project-information-ad6c6e75.js";
import { u as je } from "../../../../modules/use-crm-basics-c35b230b.js";
import { u as Se } from "../../../../modules/use-crm-user-tree-f2f683a5.js";
import { u as Le, m as We, n as Je } from "../../../../modules/use-form-data-13311836.js";
import { u as xe } from "../../../../modules/use-crm-project-information-18afe991.js";
import Ke from "../components/tabular-information.vue.js";
import Me from "../../components/information-description/index.vue.js";
import "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
const Be = { class: "head-container" }, Ge = { key: 1 }, na = { __name: "project-follow-up", props: { modelValue: { type: Boolean, default: false }, currentInformation: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "submit-success"], setup(E, { emit: B }) {
  const { user: L } = he("user"), n = E, G = pe(), y = B, { visible: H, handleClose: V } = ye({ emit: y, props: n, showHook: ae, closeHook: oe }), { formItemList: R, fetchFormItemList: Q, fetchFormDetail: z, serchFormDetail: A } = Le(), { basicsConfigMap: q } = je(), { userTree: X } = Se(), { sectionTree: Y } = We(), { projectInformationMap: Z } = xe(), { tenderConfigMap: $ } = Je(), ee = Ne(() => {
    const o = [];
    return Ve.toArr(t).forEach((l) => {
      (l.V === t.PROJECT_TRACK_DOWN.V || l.V === t.QUALIFICATION_REVIEW.V || l.V === t.APPLICATION_TENDER.V || l.V === t.PROJECT_GIVE_UP.V) && o.push(l);
    }), o;
  }), h = u(false), i = u(), S = u([]), W = u({}), r = u(), f = u([]), s = u({}), d = u({}), c = u({}), I = u({}), p = u(), N = u(false), v = u({}), w = u({}), T = u([]);
  async function ae() {
    r.value = void 0, i.value = void 0, f.value = [], b(), le(), se();
  }
  function oe() {
    i.value = void 0;
  }
  ge(() => i.value, async (o) => {
    var a;
    o ? h.value = true : h.value = false, await b(), await ((a = p.value) == null ? void 0 : a.initFormRef.clearValidate());
  }, { immediate: true });
  async function le() {
    const o = await Ae({ crmProjectInformationWarehousingId: n.currentInformation.id });
    v.value = o;
  }
  async function b() {
    let o;
    R.value = [];
    if (r.value == null) {
      f.value = [];
      return;
    }
    try {
      o = await _e();
    } catch (e) {
      console.log(e);
    }
    await Q({ isNeed: h.value, recordEnum: r.value, basicsConfigMap: q.value, user: X.value, section: Y.value, projectInformation: Z.value, tenderApplicationMap: $.value, esayFirmList: o });
    const a = ["备注", "跟进证明", "附件", "放弃说明", "标书需求"], l = ["项目名称", "项目备案号", "有效期剩余（天）", "上次跟进日期", "已跟进次数", "总工期"];
    f.value = R.value.map((e) => (a.includes(e.fieldName) ? e.span = 1 : e.span = 2, l.includes(e.fieldName) ? e.boolDisabled = true : e.boolDisabled = false, e));
    const O = f.value.findLastIndex((e) => e.span === 2);
    O % 2 === 0 && (f.value[O].span = 1), r.value === t.PROJECT_TRACK_DOWN.V && f.value.forEach((e) => {
      var U, F;
      e.fieldName === "项目名称" ? s.value[e.argumentName] = n.currentInformation.projectName : e.fieldName === "项目备案号" ? s.value[e.argumentName] = n.currentInformation.serialNumber : e.fieldName === "已跟进次数" ? s.value[e.argumentName] = v.value.followUpTimes : e.fieldName === "上次跟进日期" ? s.value[e.argumentName] = v.value.lastFollowUpDate : e.fieldName === "有效期剩余（天）" ? s.value[e.argumentName] = v.value.effectiveRemainingTime : e.fieldName === "本次跟进日期" ? s.value[e.argumentName] = (/* @__PURE__ */ new Date()).getTime() : e.fieldName === "跟进方式" ? s.value.followUpMethods = i.value ? (U = s.value) == null ? void 0 : U.followUpMethodsName : "" : e.fieldName === "备注" ? s.value.remark = i.value ? (F = s.value) == null ? void 0 : F.remark : "" : s.value[e.argumentName] = void 0;
    }), r.value === t.APPLICATION_TENDER.V && f.value.forEach((e) => {
      e.fieldName === "项目名称" ? c.value[e.argumentName] = n.currentInformation.projectName : e.fieldName === "项目备案号" ? c.value[e.argumentName] = n.currentInformation.serialNumber : (e == null ? void 0 : e.fillOutType) === "checkBox" ? c.value[e.argumentName] = [] : e.fieldName === "所属部门" ? c.value[e.argumentName] = L.value.deptId : e.fieldName === "填报人" ? c.value[e.argumentName] = L.value.id : e.fieldName === "填报日期" ? c.value[e.argumentName] = (/* @__PURE__ */ new Date()).getTime() : c.value[e.argumentName] = void 0;
    }), r.value === t.QUALIFICATION_REVIEW.V && f.value.forEach((e) => {
      e.fieldName === "项目名称" ? d.value[e.argumentName] = n.currentInformation.projectName : e.fieldName === "项目备案号" ? d.value[e.argumentName] = n.currentInformation.serialNumber : e.fieldName === "已跟进次数" ? d.value[e.argumentName] = v.value.followUpTimes : e.fieldName === "上次跟进日期" ? d.value[e.argumentName] = v.value.lastFollowUpDate : e.fieldName === "有效期剩余（天）" ? d.value[e.argumentName] = v.value.effectiveRemainingTime : d.value[e.argumentName] = void 0;
    }), r.value === t.PROJECT_GIVE_UP.V && f.value.forEach((e) => {
      e.fieldName === "项目名称" ? I.value[e.argumentName] = n.currentInformation.projectName : e.fieldName === "已跟进次数" ? I.value[e.argumentName] = v.value.followUpTimes : e.fieldName === "上次跟进日期" ? I.value[e.argumentName] = v.value.lastFollowUpDate : I.value[e.argumentName] = void 0;
    });
  }
  async function te() {
    if (!(!r.value || r.value === t.PROJECT_TRACK_DOWN.V && !i.value)) try {
      await z({ params: i.value ? W.value : n.currentInformation, tabType: t.PROJECT_TRACK_DOWN.K }), r.value === t.PROJECT_TRACK_DOWN.V && (s.value = Object.assign(A.value, v.value, { projectSerialNumber: n.currentInformation.serialNumber, projectName: n.currentInformation.projectName }));
    } catch (o) {
      console.log(o);
    }
  }
  async function ne() {
    var o;
    try {
      const a = await De({ projectId: n.currentInformation.id });
      S.value = a || [], (o = S.value) == null || o.forEach((l) => {
        l.flllowUpTime = Re(l.followUpDate, "{y}-{m}-{d} {h}:{i}");
      });
    } catch (a) {
      console.log(a, "获取项目跟进的时间历史记录列表失败");
    }
  }
  async function re(o) {
    var a, l;
    r.value = o, f.value = [], r.value === t.PROJECT_TRACK_DOWN.V && await ne(), await b(), await ((a = p.value) == null ? void 0 : a.initFormRef.clearValidate()), await ((l = p.value) == null ? void 0 : l.initFormRef.resetFields());
  }
  async function se() {
    try {
      T.value = [];
      const o = await Oe({ id: n.currentInformation.id });
      console.log(o, "data"), w.value = o || {};
      for (const a in w.value) switch (console.log(a, w.value[a], "11"), a) {
        case "canFollowUpStatus":
          w.value[a] || T.value.push(t.PROJECT_TRACK_DOWN.V);
          break;
        case "canPrequalificationStatus":
          w.value[a] || T.value.push(t.QUALIFICATION_REVIEW.V);
          break;
        case "canBidApplicationStatus":
          w.value[a] || T.value.push(t.APPLICATION_TENDER.V);
          break;
        case "canAbandonProjectTrackingStatus":
          w.value[a] || T.value.push(t.PROJECT_GIVE_UP.V);
          break;
        default:
          break;
      }
      console.log(T.value, "disabledArr.value");
    } catch (o) {
      console.log(o, "获取当前项目可操作类型失败");
    }
  }
  async function ue() {
    if (await p.value.validateForm()) {
      switch (r.value) {
        case t.PROJECT_TRACK_DOWN.V:
          await ie({ form: p.value.submitForm, id: n.currentInformation.id });
          break;
        case t.APPLICATION_TENDER.V:
          await me({ form: p.value.submitForm, id: n.currentInformation.id });
          break;
        case t.QUALIFICATION_REVIEW.V:
          await ce({ form: p.value.submitForm, id: n.currentInformation.id });
          break;
        case t.PROJECT_GIVE_UP.V:
          await fe({ form: p.value.submitForm, id: n.currentInformation.id });
          break;
      }
      G.dispatch("approval_list/fetchApprovalNum");
    }
  }
  async function ie({ form: o, id: a }) {
    try {
      N.value = true, s.value = o, s.value.crmProjectInformationWarehousingId = a, await Ue(s.value), console.log(s.value, o, "111"), j.success("项目跟进提交成功"), b(), V(), y("submit-success");
    } catch (l) {
      console.log(l);
    } finally {
      N.value = false;
    }
  }
  async function ce({ form: o, id: a }) {
    try {
      N.value = true, d.value = o, d.value.crmProjectInformationWarehousingId = a, await Fe(d.value), j.success("资格预审提交成功"), b(), V(), y("submit-success");
    } catch (l) {
      console.log(l);
    } finally {
      N.value = false;
    }
  }
  async function me({ form: o, id: a }) {
    try {
      N.value = true, c.value = o, c.value.crmProjectInformationWarehousingId = a, await ke(c.value), j.success("投标申请提交成功"), b(), V(), y("submit-success");
    } catch (l) {
      console.log(l);
    } finally {
      N.value = false;
    }
  }
  async function fe({ form: o, id: a }) {
    try {
      N.value = true, I.value = o, I.value.crmProjectInformationWarehousingId = a, await Pe(I.value), j.success("项目放弃提交成功"), b(), V(), y("submit-success");
    } catch (l) {
      console.log(l);
    } finally {
      N.value = false;
    }
  }
  async function de(o) {
    i.value = o, W.value = Object.assign({}, { id: i.value }), await b(), await te();
  }
  return (o, a) => {
    const l = Te, O = k("common-radio"), e = k("common-button"), U = k("common-select"), F = k("common-drawer");
    return _(), P(F, { "destroy-on-close": "", "close-on-click-modal": false, visible: m(H), "before-close": m(V), size: "60%", title: n.currentInformation.projectName }, { titleAfter: C(() => {
      var g, J;
      return [((g = E.currentInformation) == null ? void 0 : g.crmProjectScheduleTypeEnum) === m(M).FINISH.V ? (_(), P(l, { key: 0, type: "danger", effect: "plain", style: { "margin-right": "15px" } }, { default: C(() => a[3] || (a[3] = [x(" 项目已终止 ")])), _: 1, __: [3] })) : K("", true), D(O, { modelValue: r.value, "onUpdate:modelValue": a[0] || (a[0] = (ve) => r.value = ve), options: ee.value, type: "other", disabled: ((J = E.currentInformation) == null ? void 0 : J.crmProjectScheduleTypeEnum) === m(M).FINISH.V, disabledVal: T.value, "data-structure": { key: "V", label: "L", value: "V" }, onChange: re }, null, 8, ["modelValue", "options", "disabled", "disabledVal"])];
    }), titleRight: C(() => {
      var g;
      return [D(e, { type: "primary", size: "small", onClick: Ie(ue, ["stop"]), disabled: !r.value || h.value || !((g = m(R)) != null && g.length), loading: N.value }, { default: C(() => a[4] || (a[4] = [x(" 确认 ")])), _: 1, __: [4] }, 8, ["disabled", "loading"])];
    }), content: C(() => [be("div", Be, [r.value === m(t).PROJECT_TRACK_DOWN.V ? (_(), P(U, { key: 0, type: "other", modelValue: i.value, "onUpdate:modelValue": a[1] || (a[1] = (g) => i.value = g), options: S.value, clearable: "", "data-structure": { key: "id", label: "flllowUpTime", value: "id" }, placeholder: "选择历史创建记录", noDataText: "暂无历史创建数据", style: { width: "200px" }, class: "filter-item", onChange: de }, null, 8, ["modelValue", "options"])) : K("", true)]), h.value ? (_(), we("div", Ge, [D(Me, { "descriptions-list": m(R), "form-detail": m(A), style: { "margin-bottom": "10px" } }, null, 8, ["descriptions-list", "form-detail"]), D(Ce, { showView: "", "show-download": "", delDisabled: !r.value || h.value, files: m(A).followUpAttachment, "onUpdate:files": a[2] || (a[2] = (g) => m(A).followUpAttachment = g), "file-classify": m(Ee).RECORD_ATT.V, disabled: true }, null, 8, ["delDisabled", "files", "file-classify"])])) : (_(), P(Ke, { key: 0, ref_key: "informationRef", ref: p, "information-list": f.value, "follow-up-form": s.value, "ready-check-form": d.value, "give-up-form": I.value, "curren-sign-in": r.value, "tender-form": c.value, currentRow: E.currentInformation }, null, 8, ["information-list", "follow-up-form", "ready-check-form", "give-up-form", "curren-sign-in", "tender-form", "currentRow"]))]), _: 1 }, 8, ["visible", "before-close", "title"]);
  };
} };
export {
  na as default
};
