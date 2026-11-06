import { ref as T } from "vue";
import { computed as se } from "vue";
import { watch as ue } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as E } from "vue";
import { createBlock as O } from "vue";
import { withCtx as p } from "vue";
import { unref as i } from "vue";
import { withModifiers as P } from "vue";
import { createTextVNode as q } from "vue";
import { createCommentVNode as C } from "vue";
import { createVNode as m } from "vue";
import { createElementBlock as N } from "vue";
import { Fragment as ce } from "vue";
import { renderList as de } from "vue";
import { isRef as re } from "vue";
import { ElMessage as pe } from "element-plus";
import { ElTableColumn as me } from "element-plus";
import { ElOption as fe } from "element-plus";
import { ElSelect as ye } from "element-plus";
import { ElInput as be } from "element-plus";
import { ElForm as ve } from "element-plus";
import { _ as ge, u as Ee, o as _e, dY as g, V as Te, G as U, fQ as H, fO as f, fP as Y, fK as he, aw as Ve } from "../../../../shared/runtime.js";
import { g as Le, a as Oe, d as De } from "../../../../modules/push-message-49ab2649.js";
import { u as Re } from "../../../../modules/use-table-operate-4f84437f.js";
const Ne = { key: 0 }, Me = { key: 1 }, Ie = { key: 2 }, Ce = { __name: "push-setting", props: { visible: { type: Boolean, default: false }, detailList: { type: Array, default: () => [] }, noticeData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(y, { emit: W }) {
  const V = T({}), D = T([]), j = W, r = y, A = T([]), { visible: R, handleClose: k } = Ee({ emit: j, props: r, field: "visible" }), { maxHeight: $ } = _e({ mainBox: ".push-message-deal", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"] }, R), M = T(false), z = T(), n = T({ id: void 0, arriveList: [] }), F = { suitableObjectTypeEnum: [{ required: true, message: "请选择使用对象", trigger: "change" }], suitableObjectIdList: [{ required: true, message: "请选择推送对象", trigger: "change" }], notificationModeTypeEnum: [{ required: true, message: "请选择通知方式", trigger: "change" }] }, Q = { suitableObjectTypeEnum: [{ required: true, message: "请选择使用对象", trigger: "change" }], notificationModeTypeEnum: [{ required: true, message: "请选择通知方式", trigger: "change" }] }, S = se(() => {
    var o, e, c, s;
    return ((o = r.noticeData) == null ? void 0 : o.notificationType) === g.BUSINESS_BID_MANAGER.V || ((e = r.noticeData) == null ? void 0 : e.notificationType) === g.TECHNOLOGY_BID_MANAGER.V || ((c = r.noticeData) == null ? void 0 : c.notificationType) === g.STRUCTURE_DESIGN_BID_MANAGER.V || ((s = r.noticeData) == null ? void 0 : s.notificationType) === g.DEEPEN_DESIGN_BID_MANAGER.V ? Q : F;
  });
  ue(() => r.visible, (o) => {
    var e, c, s, d, v, b;
    o && ((e = r.noticeData) != null && e.pushNotificationConfigDetailDTOList && ((s = (c = r.noticeData) == null ? void 0 : c.pushNotificationConfigDetailDTOList) == null ? void 0 : s.length) > 0 ? (n.value = Te(r.noticeData), n.value.arriveList = [], (v = (d = n.value) == null ? void 0 : d.pushNotificationConfigDetailDTOList) == null || v.forEach(async (l) => {
      var a;
      await x(l.suitableObjectTypeEnum, l), l.suitableObjectIdList = (a = l == null ? void 0 : l.suitableObjectCommonDTOList) == null ? void 0 : a.map((I) => I.id);
    }), n.value.arriveList = (b = n.value) == null ? void 0 : b.pushNotificationConfigDetailDTOList) : (n.value = { id: void 0, arriveList: [] }, K(n.value.arriveList)));
  }, { immediate: true });
  const { init: K, addRow: J } = Re({}, 0), { tableValidate: X, cleanUpData: Z } = Ve({ rules: S });
  function ee({ row: o, column: e }) {
    if (!o) return;
    const c = S;
    let s = true;
    return o.verify && Object.keys(o.verify) && Object.keys(o.verify).length > 0 && (o.verify[e.property] === false && (s = he(e.property, c[e.property], o)), s && (o.verify[e.property] = true)), s ? "" : "mask-td";
  }
  function te(o, e) {
    o.splice(e, 1), console.log(o, n.value.arriveList, "删除");
  }
  function ae(o, e) {
    o === f.REGULAR.V && (e.timeTypeEnum = Y.MINUTE.V);
  }
  async function ie() {
    var o, e, c, s, d, v, b;
    if (D.value = [], n.value.arriveList && ((o = n.value.arriveList) == null ? void 0 : o.length) > 0) {
      const { validResult: l, dealList: a } = X(n.value.arriveList);
      if (!l) return;
      D.value = Z(a);
    } else D.value = [];
    try {
      M.value = true;
      const l = (e = D.value) == null ? void 0 : e.map((a) => ({ notificationModeTypeEnum: a.notificationModeTypeEnum, suitableObjectIdList: a.suitableObjectIdList, suitableObjectTypeEnum: a.suitableObjectTypeEnum, number: a.notificationModeTypeEnum === f.RATION.V ? a.number : void 0, duration: a.notificationModeTypeEnum === f.REGULAR.V ? a.duration : void 0, timeTypeEnum: a.notificationModeTypeEnum === f.REGULAR.V ? a.timeTypeEnum : void 0 }));
      n.value.arriveList && ((c = n.value.arriveList) != null && c.length) ? await Oe({ notificationType: (s = r.noticeData) == null ? void 0 : s.notificationType, operationalModuleType: (d = r.noticeData) == null ? void 0 : d.operationalModuleType }, l) : await De({ notificationType: (v = r.noticeData) == null ? void 0 : v.notificationType, operationalModuleType: (b = r.noticeData) == null ? void 0 : b.operationalModuleType }), pe.success("保存成功"), j("success"), k();
    } catch (l) {
      console.log(l);
    } finally {
      M.value = false;
    }
  }
  async function x(o, e) {
    var c, s, d, v;
    if (e.suitableObjectIdList = void 0, !!e.suitableObjectTypeEnum) try {
      V.value = {};
      const b = await Le({ suitableObjectTypeEnum: o });
      A.value = b || [];
      const l = [...n.value.arriveList];
      ((c = l.filter((a) => a.uid)) == null ? void 0 : c.length) > 0 ? V.value = (s = l == null ? void 0 : l.filter((a) => a.uid)) == null ? void 0 : s.find((a) => a.uid === e.uid) : V.value = (v = (d = n.value) == null ? void 0 : d.pushNotificationConfigDetailDTOList) == null ? void 0 : v.find((a) => a.id === e.id), V.value.pushList = [], V.value.pushList = A.value;
    } catch (b) {
      console.log(b, "获取推送对象失败");
    }
  }
  return (o, e) => {
    var G;
    const c = h("common-button"), s = h("common-select"), d = me, v = h("common-select-v2"), b = fe, l = ye, a = be, I = h("common-input-number"), oe = h("common-table"), ne = ve, le = h("common-dialog");
    return E(), O(le, { title: `${(G = y.noticeData) == null ? void 0 : G.notificationTypeName}`, modelValue: i(R), "onUpdate:modelValue": e[1] || (e[1] = (t) => re(R) ? R.value = t : null), width: "1000px", top: "5vh", "close-on-click-modal": false, "before-close": i(k), "custom-class": "push-message-deal" }, { titleRight: p(() => [i(U)(y.permission.customObjBtn) ? (E(), O(c, { key: 0, type: "warning", size: "default", icon: "el-icon-plus", disabled: n.value.arriveList && n.value.arriveList.length === 1, onClick: e[0] || (e[0] = P((t) => i(J)(n.value.arriveList), ["stop"])) }, { default: p(() => e[2] || (e[2] = [q(" 添加一行 ")])), _: 1, __: [2] }, 8, ["disabled"])) : C("", true), i(U)(y.permission.pushSave) ? (E(), O(c, { key: 1, size: "default", type: "primary", loading: M.value, onClick: ie }, { default: p(() => e[3] || (e[3] = [q(" 保 存 ")])), _: 1, __: [3] }, 8, ["loading"])) : C("", true)]), default: p(() => [m(ne, { ref_key: "formRef", ref: z, model: n.value, "label-width": "180px" }, { default: p(() => [m(oe, { ref: "tableRef1", data: n.value.arriveList, "show-empty-symbol": false, "empty-text": "暂无数据", "max-height": i($), "cell-class-name": ee }, { default: p(() => [m(d, { key: "suitableObjectTypeEnum", prop: "suitableObjectTypeEnum", "show-overflow-tooltip": true, label: "适用对象" }, { default: p(({ row: { sourceRow: t } }) => {
      var u, L, _, B;
      return [m(s, { modelValue: t.suitableObjectTypeEnum, "onUpdate:modelValue": (w) => t.suitableObjectTypeEnum = w, options: i(H).ENUM, type: "enum", clearable: "", disabledVal: ((u = y.noticeData) == null ? void 0 : u.notificationType) === i(g).BUSINESS_BID_MANAGER.V || ((L = y.noticeData) == null ? void 0 : L.notificationType) === i(g).TECHNOLOGY_BID_MANAGER.V || ((_ = y.noticeData) == null ? void 0 : _.notificationType) === i(g).STRUCTURE_DESIGN_BID_MANAGER.V || ((B = y.noticeData) == null ? void 0 : B.notificationType) === i(g).DEEPEN_DESIGN_BID_MANAGER.V ? [] : [i(H).SYSTEM.V], style: { width: "100%" }, placeholder: "适用对象", onChange: (w) => x(t.suitableObjectTypeEnum, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabledVal", "onChange"])];
    }), _: 1 }), m(d, { key: "suitableObjectIdList", prop: "suitableObjectIdList", "show-overflow-tooltip": true, label: "推送对象", width: "220" }, { default: p(({ row: { sourceRow: t } }) => [m(v, { modelValue: t.suitableObjectIdList, "onUpdate:modelValue": (u) => t.suitableObjectIdList = u, options: t.pushList, type: "other", "collapse-tags": "", "max-collapse-tags": 1, filterable: "", clearable: "", multiple: "", style: { width: "100%" }, placeholder: "推送对象" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 }), m(d, { key: "notificationModeTypeEnum", prop: "notificationModeTypeEnum", "show-overflow-tooltip": true, label: "通知方式" }, { default: p(({ row: { sourceRow: t } }) => {
      var u, L;
      return [m(s, { modelValue: t.notificationModeTypeEnum, "onUpdate:modelValue": (_) => t.notificationModeTypeEnum = _, options: i(f).ENUM, type: "enum", clearable: "", style: { width: "100%" }, placeholder: "通知方式", disabledVal: ((u = y.noticeData) == null ? void 0 : u.notificationType) === i(g).QUANLITY_TEST.V ? [i(f).NOW.V] : ((L = y.noticeData) == null ? void 0 : L.notificationType) === i(g).PROCESS_SLUGGISH.V ? [i(f).NOW.V, i(f).REGULAR.V] : [i(f).REGULAR.V, i(f).RATION.V], onChange: (_) => ae(_, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabledVal", "onChange"])];
    }), _: 1 }), m(d, { key: "timeConfig", prop: "timeConfig", "show-overflow-tooltip": true, label: "通知时间配置", width: "200" }, { default: p(({ row: { sourceRow: t } }) => [t.notificationModeTypeEnum === i(f).REGULAR.V ? (E(), N("div", Ne, [m(a, { modelValue: t.duration, "onUpdate:modelValue": (u) => t.duration = u, type: "number", placeholder: "时长", size: "default", min: 0, maxlength: 4, style: { width: "100%" } }, { append: p(() => [m(l, { modelValue: t.timeTypeEnum, "onUpdate:modelValue": (u) => t.timeTypeEnum = u, style: { width: "90px" }, placeholder: "类型" }, { default: p(() => [(E(true), N(ce, null, de(i(Y).ENUM, (u) => (E(), O(b, { label: u.L, value: u.V, key: u.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])])) : t.notificationModeTypeEnum === i(f).RATION.V ? (E(), N("div", Me, [m(I, { modelValue: t.number, "onUpdate:modelValue": (u) => t.number = u, step: 1, min: 1, precision: 0, clearable: "", controls: false, placeholder: "输入数量" }, null, 8, ["modelValue", "onUpdate:modelValue"])])) : (E(), N("div", Ie, "/"))]), _: 1 }), m(d, { label: "操作", width: "70px", align: "center", fixed: "right" }, { default: p(({ $index: t }) => [i(U)(y.permission.del) ? (E(), O(c, { key: 0, type: "danger", icon: "el-icon-delete", style: { padding: "6px" }, onClick: P((u) => te(n.value.arriveList, t), ["stop"]) }, null, 8, ["onClick"])) : C("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, Se = ge(Ce, [["__scopeId", "data-v-19e6819d"]]);
export {
  Se as default
};
