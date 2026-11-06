import { ref as E } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as n } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { unref as t } from "vue";
import { createTextVNode as S } from "vue";
import { createCommentVNode as h } from "vue";
import { createVNode as r } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as C } from "vue";
import { toDisplayString as v } from "vue";
import { isRef as Ie } from "vue";
import { ElMessageBox as te } from "element-plus";
import { ElMessage as ne } from "element-plus";
import { ElTag as Ve } from "element-plus";
import { ElFormItem as De } from "element-plus";
import { ElTooltip as Ne } from "element-plus";
import { ElDatePicker as ke } from "element-plus";
import { ElForm as Fe } from "element-plus";
import { ElDescriptionsItem as Se } from "element-plus";
import { ElInput as Ce } from "element-plus";
import { ElDescriptions as je } from "element-plus";
import { u as Oe } from "../../../../../modules/user-template-config-16e71de8.js";
import { g as xe, p as Pe } from "../../../../../modules/bid-list-077bf24b.js";
import { _ as Ue, u as Le, dA as le, lq as I, dK as oe, dE as ie, i as qe, lu as W, lv as P, G as U, L as He, lw as Ae, lx as Ge, p as Je, dw as ze, R as re, S as se, ly as ue } from "../../../../../shared/runtime.js";
import { u as We } from "../../../../../modules/use-crm-project-information-18afe991.js";
import { u as Ye } from "../../../../../modules/use-form-config-data-098a0552.js";
import $e from "../../information-description/index.vue.js";
import { _ as Ke } from "../../../../../modules/tender-apply-config-select-032e3e0f.js";
import "../../../../../modules/project-information-053c195b.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const Qe = { key: 1, class: "single-line-ellipsis" }, Xe = { key: 1, style: { display: "inline-block", width: "220px" } }, Ze = { key: 1, style: { display: "inline-block", width: "200px" } }, ea = { key: 1 }, aa = { key: 1 }, ta = { key: 1 }, na = { key: 1 }, la = { key: 1 }, oa = { key: 1 }, ia = { key: 1 }, ra = { key: 1, style: { "margin-bottom": "10px" } }, sa = { __name: "detail", props: { modelValue: { type: Boolean, default: void 0 }, currentRow: { type: Object, default: () => {
} }, tenderType: { type: Number, default: void 0 }, crmSpecialBubmissionStatusEnum: { type: [Number, String], default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(g, { emit: de }) {
  const c = g, H = de, { visible: A, handleClose: G } = Le({ emit: H, props: c, showHook: ye, closeHook: ve }), { projectInformationMap: Y } = We(), $ = E([]), o = E({ isNeedFill: true, projectBidManagerUserIdList: [], projectBidManagerFinishDate: void 0, difficultyFactorId: void 0, crmProjectInformationWarehousingId: void 0, crmTenderRequirementTypeEnum: void 0 }), V = E(), J = E(false), D = E({}), j = E(), s = E({ technologyBidManagerJobDescriptionId: void 0, technologyBidManagerRenderings: void 0, technologyBidManagerStructureName: void 0, technologyBidManagerCompletion: void 0, technologyBidManagerBusinessTrip: void 0, technologyBidManagerCustomerReception: void 0, technologyBidManagerRemarks: void 0 }), d = E(false), M = E({}), ce = { isNeedFill: [{ required: true, message: "请选择类型", trigger: "change" }], projectBidManagerUserIdList: [{ required: true, message: "请选择负责人", trigger: "change" }], projectBidManagerFinishDate: [{ required: true, message: "请选择完成日期", trigger: "change" }], difficultyFactorId: [{ required: true, message: "请选择难度系数", trigger: "change" }] }, me = { technologyBidManagerJobDescriptionId: [{ required: true, message: "请选择工作内容", trigger: "change" }] }, { fetchFormItemList: pe, fetchFormDetail: ge, formItemList: K, serchFormDetail: m, chargePersonalDatail: _, fetchUserChargeDetail: fe } = Ye();
  async function ye() {
    var i, e;
    d.value = false, (i = V.value) == null || i.clearValidate(), await Te(), await be(), await he(), await Be(), await z(), $.value = ((e = D.value) == null ? void 0 : e.userSimpleInfoDTOS) || [];
  }
  async function ve() {
    var i, e, T, y;
    await ((i = V.value) == null ? void 0 : i.resetFields()), await ((e = V.value) == null ? void 0 : e.clearValidate()), await ((T = j.value) == null ? void 0 : T.resetFields()), await ((y = j.value) == null ? void 0 : y.clearValidate());
  }
  async function Te() {
    var i, e, T;
    try {
      await ge({ pageEnum: le.APPLICATION_TENDER.V, params: c.currentRow, tenderType: (i = c.currentRow) == null ? void 0 : i.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: ((e = c.currentRow) == null ? void 0 : e.crmTenderRequirementTypeEnum) === I.SETTLEMENT_METHOD.V ? (T = c.currentRow) == null ? void 0 : T.crmSpecialBubmissionStatusEnum : void 0 }), console.log(m.value, "serchFormDetail"), s.value.technologyBidManagerJobDescriptionId = m.value.technologyBidManagerJobDescriptionId || void 0, s.value.technologyBidManagerRenderings = m.value.technologyBidManagerRenderings || void 0, s.value.technologyBidManagerStructureName = m.value.technologyBidManagerStructureName || void 0, s.value.technologyBidManagerCompletion = m.value.technologyBidManagerCompletion || void 0, s.value.technologyBidManagerBusinessTrip = m.value.technologyBidManagerBusinessTrip || void 0, s.value.technologyBidManagerCustomerReception = m.value.technologyBidManagerCustomerReception || void 0, s.value.technologyBidManagerRemarks = m.value.technologyBidManagerRemarks || void 0;
    } catch (y) {
      console.log(y);
    }
  }
  async function z() {
    var i, e, T, y, R, f, w, N, L, q, O;
    try {
      await fe({ params: c.currentRow, tenderType: (i = c.currentRow) == null ? void 0 : i.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: ((e = c.currentRow) == null ? void 0 : e.crmTenderRequirementTypeEnum) === I.SETTLEMENT_METHOD.V ? (T = c.currentRow) == null ? void 0 : T.crmSpecialBubmissionStatusEnum : void 0 }), console.log(_.value, "chargePersonalDatail"), D.value && D.value.crmPersonOperateTypeEnum === oe.ROUTINE_OPERATIONS.V ? (o.value.projectBidManagerUserIdList = ((y = _.value) == null ? void 0 : y.projectBidManagerUserIdList) || [], o.value.projectBidManagerUserNameList = ((R = _.value) == null ? void 0 : R.projectBidManagerUserName) || void 0) : (o.value.projectBidManagerUserIdList = ((w = (f = D.value) == null ? void 0 : f.userSimpleInfoDTOS) == null ? void 0 : w.map((p) => p.userId)) || [], o.value.projectBidManagerUserNameList = ((N = _.value) == null ? void 0 : N.projectBidManagerUserName) || void 0), o.value.projectBidManagerFinishDate = _.value.projectBidManagerFinishDate || void 0, o.value.difficultyFactorId = _.value.difficultyFactorId || void 0, o.value.difficultyFactorName = (O = (q = (L = Y.value[ie.DIFFICULTY_FACTOR_CONFIG.V]) == null ? void 0 : L.crmProjectInformationConfigDTOS) == null ? void 0 : q.find((p) => p.id === o.value.difficultyFactorId)) == null ? void 0 : O.name, o.value.isNeedFill = qe(_.value.isNeedFill) ? _.value.isNeedFill : true;
    } catch (p) {
      console.log(p);
    }
  }
  async function he() {
    try {
      await pe({ pageEnum: le.APPLICATION_TENDER.V }), console.log(K.value);
    } catch (i) {
      console.log(i);
    }
  }
  async function Be() {
    var i;
    try {
      const e = await Oe({ crmPersonTemplateEnum: (i = c.currentRow) == null ? void 0 : i.crmTenderRequirementTypeEnum });
      D.value = e || {};
    } catch (e) {
      console.log(e, "获取人员模板配置详情失败");
    }
  }
  async function be() {
    var i;
    if (c.tenderType === W.BIDDING_METHOD.V) try {
      const e = await xe({ crmTenderRequirementTypeEnum: W.BIDDING_METHOD.V, id: (i = c.currentRow) == null ? void 0 : i.id });
      M.value = e || {};
    } catch (e) {
      console.log(e, "获取投标报价字段回显失败");
    }
  }
  async function Ee() {
    V.value.validate(async (i) => {
      var T, y, R, f, w;
      if (!(!(((T = c.currentRow) == null ? void 0 : T.crmTenderRequirementTypeEnum) !== I.SETTLEMENT_METHOD.V || await ((y = j.value) == null ? void 0 : y.validate())) || !i)) try {
        J.value = true, await te.confirm("是否确认当前选择的配置？", "提示", { closeOnClickModal: false, confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), o.value.crmProjectInformationWarehousingId = c.currentRow.id, o.value.crmTenderRequirementTypeEnum = (R = c.currentRow) == null ? void 0 : R.crmTenderRequirementTypeEnum, ((f = c.currentRow) == null ? void 0 : f.crmTenderRequirementTypeEnum) === I.SETTLEMENT_METHOD.V ? await ue({ ...o.value, crmSpecialBubmissionStatusEnum: (w = c.currentRow) == null ? void 0 : w.crmSpecialBubmissionStatusEnum, ...s.value }) : await ue({ ...o.value }), ne.success("设置成功"), H("success"), G();
      } catch (N) {
        console.log(N, "设置失败");
      } finally {
        J.value = false;
      }
    });
  }
  async function Me() {
    d.value = false, await z();
  }
  async function _e() {
    var i, e;
    d.value = true, await ((i = V.value) == null ? void 0 : i.clearValidate()), await ((e = j.value) == null ? void 0 : e.clearValidate()), await z();
  }
  async function Re() {
    var i;
    try {
      await te.confirm("一旦项目中止，后续该项目流程无法进行任何操作，并流入公共池!", "提示", { closeOnClickModal: false, confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Pe({ id: (i = c.currentRow) == null ? void 0 : i.id }) && (ne.success("项目终止成功"), H("success"), G());
    } catch (e) {
      console.log(e, "项目终止失败");
    }
  }
  return (i, e) => {
    const T = Ve, y = x("common-button"), R = x("common-radio"), f = De, w = x("common-select-v2"), N = Ne, L = ke, q = x("common-select"), O = Fe, p = Se, k = Ce, Q = je, we = x("common-drawer");
    return n(), u(we, { modelValue: t(A), "onUpdate:modelValue": e[13] || (e[13] = (b) => Ie(A) ? A.value = b : null), "before-close": t(G), "close-on-click-modal": false, size: "100%", title: "投标列表详情" }, { titleAfter: a(() => {
      var b;
      return [((b = g.currentRow) == null ? void 0 : b.crmProjectScheduleTypeEnum) === t(P).FINISH.V ? (n(), u(T, { key: 0, type: "danger", effect: "plain" }, { default: a(() => e[14] || (e[14] = [S(" 项目已终止 ")])), _: 1, __: [14] })) : h("", true)];
    }), titleRight: a(() => {
      var b, l, F, X, Z, ee, ae;
      return [t(U)((b = g.permission) == null ? void 0 : b.finish) && !d.value && ((l = g.currentRow) == null ? void 0 : l.crmTenderRequirementTypeEnum) === t(I).BIDDING_METHOD.V ? (n(), u(y, { key: 0, disabled: ((F = g.currentRow) == null ? void 0 : F.crmProjectScheduleTypeEnum) === t(P).FINISH.V, type: "danger", onClick: Re }, { default: a(() => e[15] || (e[15] = [S(" 项目终止 ")])), _: 1, __: [15] }, 8, ["disabled"])) : h("", true), t(U)(g.permission.save) && !d.value ? (n(), u(y, { key: 1, disabled: ((X = g.currentRow) == null ? void 0 : X.crmProjectScheduleTypeEnum) === t(P).FINISH.V, type: "primary", onClick: _e }, { default: a(() => e[16] || (e[16] = [S(" 编辑 ")])), _: 1, __: [16] }, 8, ["disabled"])) : h("", true), t(U)(g.permission.save) && d.value ? (n(), u(y, { key: 2, disabled: ((Z = g.currentRow) == null ? void 0 : Z.crmProjectScheduleTypeEnum) === t(P).FINISH.V, type: "warning", onClick: Me }, { default: a(() => e[17] || (e[17] = [S(" 取消编辑 ")])), _: 1, __: [17] }, 8, ["disabled"])) : h("", true), t(U)(g.permission.save) ? (n(), u(y, { key: 3, type: "success", disabled: !d.value || ((ee = g.currentRow) == null ? void 0 : ee.crmProjectScheduleTypeEnum) === t(P).FINISH.V, loading: J.value, onClick: Ee }, { default: a(() => e[18] || (e[18] = [S(" 保存 ")])), _: 1, __: [18] }, 8, ["disabled", "loading"])) : h("", true), t(U)(g.permission.export) ? (n(), u(He, { key: 4, fn: t(Ae), params: { id: c.currentRow.id, crmTenderRequirementTypeEnum: (ae = c.currentRow) == null ? void 0 : ae.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: g.crmSpecialBubmissionStatusEnum }, size: "default" }, { default: a(() => e[19] || (e[19] = [S(" 下载 ")])), _: 1, __: [19] }, 8, ["fn", "params"])) : h("", true)];
    }), content: a(() => {
      var b;
      return [r(O, { ref_key: "formRef", ref: V, "label-position": "left", model: o.value, inline: "", rules: ce, style: { "margin-bottom": "30px" } }, { default: a(() => [g.tenderType > t(I).SETTLEMENT_METHOD.V ? (n(), u(f, { key: 0, label: "类型：", prop: "isNeedFill" }, { default: a(() => [r(R, { modelValue: o.value.isNeedFill, "onUpdate:modelValue": e[0] || (e[0] = (l) => o.value.isNeedFill = l), type: "enum", options: t(Ge).ENUM, style: { width: "220px" }, disabled: !d.value }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })) : h("", true), o.value.isNeedFill ? (n(), u(f, { key: 1, label: d.value ? "选择负责人：" : "当前负责人：", prop: "projectBidManagerUserIdList" }, { default: a(() => {
        var l;
        return [d.value ? (n(), u(w, { key: 0, modelValue: o.value.projectBidManagerUserIdList, "onUpdate:modelValue": e[1] || (e[1] = (F) => o.value.projectBidManagerUserIdList = F), options: $.value, filterable: "", clearable: "", multiple: "", "collapse-tags-tooltip": "", "collapse-tags": "", "max-collapse-tags": 2, dataStructure: { value: "userId", label: "userName", key: "userId" }, type: "other", class: "input-underline", placeholder: "请选择负责人", disabled: ((l = D.value) == null ? void 0 : l.crmPersonOperateTypeEnum) === t(oe).NOT_MODIFIABLE.V, style: { "margin-right": "10px", width: "360px" } }, null, 8, ["modelValue", "options", "disabled"])) : (n(), B("div", Qe, [r(N, { effect: "light", content: `${o.value.projectBidManagerUserNameList}`, placement: "top" }, { default: a(() => [C("span", null, v(o.value.projectBidManagerUserNameList), 1)]), _: 1 }, 8, ["content"])]))];
      }), _: 1 }, 8, ["label"])) : h("", true), o.value.isNeedFill ? (n(), u(f, { key: 2, label: d.value ? "选择完成日期：" : "当前完成日期：", prop: "projectBidManagerFinishDate" }, { default: a(() => [d.value ? (n(), u(L, { key: 0, placeholder: "请选择完成日期", style: { "margin-right": "10px" }, clearable: "", class: "input-underline", modelValue: o.value.projectBidManagerFinishDate, "onUpdate:modelValue": e[2] || (e[2] = (l) => o.value.projectBidManagerFinishDate = l), "value-format": "x" }, null, 8, ["modelValue"])) : (n(), B("span", Xe, v(t(Je)(o.value.projectBidManagerFinishDate, "{y}-{m}-{d}")), 1))]), _: 1 }, 8, ["label"])) : h("", true), o.value.isNeedFill ? (n(), u(f, { key: 3, label: d.value ? "选择难度系数：" : "当前难度系数：", prop: "difficultyFactorId" }, { default: a(() => {
        var l;
        return [d.value ? (n(), u(q, { key: 0, placeholder: "请选择难度系数", clearable: "", class: "input-underline", modelValue: o.value.difficultyFactorId, "onUpdate:modelValue": e[3] || (e[3] = (F) => o.value.difficultyFactorId = F), options: (l = t(Y)[t(ie).DIFFICULTY_FACTOR_CONFIG.V]) == null ? void 0 : l.crmProjectInformationConfigDTOS }, null, 8, ["modelValue", "options"])) : (n(), B("span", Ze, v(o.value.difficultyFactorName), 1))];
      }), _: 1 }, 8, ["label"])) : h("", true)]), _: 1 }, 8, ["model"]), ((b = g.currentRow) == null ? void 0 : b.crmTenderRequirementTypeEnum) === t(I).SETTLEMENT_METHOD.V ? (n(), u(O, { key: 0, ref_key: "newFormRef", ref: j, model: s.value, rules: me, "label-position": "right", style: { "margin-bottom": "15px" }, size: "default" }, { default: a(() => [r(Q, { column: 3, border: "" }, { default: a(() => [r(p, { label: "工作内容", "label-class-name": "my-label" }, { default: a(() => [r(f, { label: "", prop: "technologyBidManagerJobDescriptionId" }, { default: a(() => [d.value ? (n(), u(Ke, { key: 0, modelValue: s.value.technologyBidManagerJobDescriptionId, "onUpdate:modelValue": e[4] || (e[4] = (l) => s.value.technologyBidManagerJobDescriptionId = l), crmTenderRequestConfigEnum: t(ze).WORK_CONTENT_TYPE.V, crmSpecialBubmissionStatusEnum: g.currentRow.crmSpecialBubmissionStatusEnum, clearable: "", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "crmTenderRequestConfigEnum", "crmSpecialBubmissionStatusEnum"])) : (n(), B("span", ea, v(t(m).technologyBidManagerJobDescriptionName), 1))]), _: 1 })]), _: 1 }), r(p, { label: "效果图" }, { default: a(() => [r(f, { label: "", prop: "technologyBidManagerRenderings" }, { default: a(() => [d.value ? (n(), u(k, { key: 0, modelValue: s.value.technologyBidManagerRenderings, "onUpdate:modelValue": e[5] || (e[5] = (l) => s.value.technologyBidManagerRenderings = l), type: "text", maxlength: "15", placeholder: "填写效果图", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])) : (n(), B("span", aa, v(t(m).technologyBidManagerRenderings), 1))]), _: 1 })]), _: 1 }), r(p, { label: "结构" }, { default: a(() => [r(f, { label: "", prop: "technologyBidManagerStructureName" }, { default: a(() => [d.value ? (n(), u(k, { key: 0, modelValue: s.value.technologyBidManagerStructureName, "onUpdate:modelValue": e[6] || (e[6] = (l) => s.value.technologyBidManagerStructureName = l), type: "text", maxlength: "15", placeholder: "填写结构", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])) : (n(), B("span", ta, v(t(m).technologyBidManagerStructureName), 1))]), _: 1 })]), _: 1 }), r(p, { label: "完成情况" }, { default: a(() => [r(f, { label: "", prop: "technologyBidManagerCompletion" }, { default: a(() => [d.value ? (n(), u(k, { key: 0, modelValue: s.value.technologyBidManagerCompletion, "onUpdate:modelValue": e[7] || (e[7] = (l) => s.value.technologyBidManagerCompletion = l), type: "text", maxlength: "15", placeholder: "填写完成情况", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])) : (n(), B("span", na, v(t(m).technologyBidManagerCompletion), 1))]), _: 1 })]), _: 1 }), r(p, { label: "出差" }, { default: a(() => [r(f, { label: "", prop: "technologyBidManagerBusinessTrip" }, { default: a(() => [d.value ? (n(), u(k, { key: 0, modelValue: s.value.technologyBidManagerBusinessTrip, "onUpdate:modelValue": e[8] || (e[8] = (l) => s.value.technologyBidManagerBusinessTrip = l), type: "text", maxlength: "15", placeholder: "填写出差", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])) : (n(), B("span", la, v(t(m).technologyBidManagerBusinessTrip), 1))]), _: 1 })]), _: 1 }), r(p, { label: "客户接待" }, { default: a(() => [r(f, { label: "", prop: "technologyBidManagerCustomerReception" }, { default: a(() => [d.value ? (n(), u(k, { key: 0, modelValue: s.value.technologyBidManagerCustomerReception, "onUpdate:modelValue": e[9] || (e[9] = (l) => s.value.technologyBidManagerCustomerReception = l), type: "text", maxlength: "15", placeholder: "填写客户接待", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])) : (n(), B("span", oa, v(t(m).technologyBidManagerCustomerReception), 1))]), _: 1 })]), _: 1 }), r(p, { label: "备注", span: 2 }, { default: a(() => [r(f, { label: "", prop: "technologyBidManagerRemarks" }, { default: a(() => [d.value ? (n(), u(k, { key: 0, modelValue: s.value.technologyBidManagerRemarks, "onUpdate:modelValue": e[10] || (e[10] = (l) => s.value.technologyBidManagerRemarks = l), type: "text", maxlength: "15", placeholder: "填写备注", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])) : (n(), B("span", ia, v(t(m).technologyBidManagerRemarks), 1))]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"])) : h("", true), g.tenderType === t(W).BIDDING_METHOD.V ? (n(), B("div", ra, [r(Q, { column: 3, border: "", style: { "margin-bottom": "10px" } }, { default: a(() => [r(p, { label: "投标报价(万元)" }, { default: a(() => [C("span", null, v(M.value.businessProjectBidManagerQuote), 1)]), _: 1 }), r(p, { label: "工程量(吨)" }, { default: a(() => [C("span", null, v(M.value.businessProjectBidManagerEstimatedWorks), 1)]), _: 1 }), r(p, { label: "成本(万元)" }, { default: a(() => [C("span", null, v(M.value.businessProjectBidManagerCost), 1)]), _: 1 }), r(p, { label: "毛利(%)" }, { default: a(() => [C("span", null, v(M.value.businessProjectBidManagerGrossProfit), 1)]), _: 1 }), r(p, { label: "备注", span: 2 }, { default: a(() => [C("span", null, v(M.value.businessProjectBidManagerRemark), 1)]), _: 1 })]), _: 1 }), r(re, { showView: "", "show-download": "", files: M.value.bidManagerAttachments, "onUpdate:files": e[11] || (e[11] = (l) => M.value.bidManagerAttachments = l), "file-classify": t(se).RECORD_ATT.V, disabled: true, delDisabled: true }, null, 8, ["files", "file-classify"])])) : h("", true), r(t($e), { "descriptions-list": t(K), "form-detail": t(m), style: { "margin-bottom": "10px" } }, null, 8, ["descriptions-list", "form-detail"]), r(re, { showView: "", "show-download": "", files: t(m).attachmentDTOList, "onUpdate:files": e[12] || (e[12] = (l) => t(m).attachmentDTOList = l), "file-classify": t(se).RECORD_ATT.V, disabled: true, delDisabled: true }, null, 8, ["files", "file-classify"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ha = Ue(sa, [["__scopeId", "data-v-c3b6c2b9"]]);
export {
  ha as default
};
