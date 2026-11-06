import { dt as c } from "../shared/runtime.js";
import { u as A } from "./use-crm-basics-c35b230b.js";
import { ref as p } from "vue";
import { computed as y } from "vue";
import { watch as b } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as S } from "vue";
import { createBlock as h } from "vue";
import { mergeProps as g } from "vue";
import { createCommentVNode as C } from "vue";
import { Fragment as D } from "vue";
const P = { __name: "basics-config-select", props: { boolFirmNature: { type: Boolean, default: true }, boolFirmType: { type: Boolean, default: true }, boolIndustry: { type: Boolean, default: true }, boolCorporateRepuration: { type: Boolean, default: true }, firmNatureId: { type: [Array, Number, String, void 0], default: void 0 }, firmTypeId: { type: [Array, Number, String, void 0], default: void 0 }, industryId: { type: [Array, Number, String, void 0], default: void 0 }, corporateRepurationId: { type: [Array, Number, String, void 0], default: void 0 }, firmNatureClearable: { type: Boolean, default: false }, corporateRepurationClearable: { type: Boolean, default: false }, firmTypeClearable: { type: Boolean, default: false }, industryClearable: { type: Boolean, default: false }, firmNaturePlaceholder: { type: String, default: "请选择企业性质" }, firmTypePlaceholder: { type: String, default: "请选择企业类型" }, industryPlaceholder: { type: String, default: "请选择所属行业" }, corporateRepurationPlaceholder: { type: String, default: "请选择企业信誉" }, firmNatureDisabled: { type: Boolean, default: false }, firmTypeDisabled: { type: Boolean, default: false }, industryDisabled: { type: Boolean, default: false }, corporateRepurationDisabled: { type: Boolean, default: false }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, defaultValue: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, showExtra: { type: Boolean, default: false }, choseIndex: { type: [Number, String], default: void 0 }, disabledVal: { type: Array, default: () => [] } }, emits: ["firmNatureChange", "firmTypeChange", "industryChange", "corporateRepurationChange", "update:firmNatureId", "update:firmTypeId", "update:industryId", "update:corporateRepurationId"], setup(e, { emit: T }) {
  const t = T, r = e, { basicsConfigMap: n } = A(), u = p(), d = p(), s = p(), f = p(), N = y(() => {
    var l;
    return (l = n.value[c.UNIT_NATURE_CONFIG.V]) == null ? void 0 : l.crmBasicsConfigDTOS;
  }), I = y(() => {
    var l;
    return (l = n.value[c.UNIT_TYPE_CONFIG.V]) == null ? void 0 : l.crmBasicsConfigDTOS;
  }), V = y(() => {
    var l;
    return (l = n.value[c.BELONG_INDUSTRY_CONFIG.V]) == null ? void 0 : l.crmBasicsConfigDTOS;
  }), w = y(() => {
    var l;
    return (l = n.value[c.FIRM_REPUTATION.V]) == null ? void 0 : l.crmBasicsConfigDTOS;
  });
  b(() => r.firmNatureId, (a) => {
    u.value = a;
  }, { immediate: true }), b(() => r.firmTypeId, (a) => {
    d.value = a;
  }, { immediate: true }), b(() => r.industryId, (a) => {
    s.value = a;
  }, { immediate: true }), b(() => r.corporateRepurationId, (a) => {
    f.value = a;
  }, { immediate: true });
  function B(a) {
    t("update:firmNatureId", u.value), t("firmNatureChange", a);
  }
  function O(a) {
    t("update:firmTypeId", d.value), t("firmTypeChange", a);
  }
  function v(a) {
    t("update:industryId", s.value), t("industryChange", a);
  }
  function R(a) {
    t("update:corporateRepurationId", f.value), t("corporateRepurationChange", a);
  }
  return (a, l) => {
    const m = E("common-select");
    return i(), S(D, null, [e.boolFirmNature ? (i(), h(m, g({ key: 0 }, a.$attrs, { modelValue: u.value, "onUpdate:modelValue": l[0] || (l[0] = (o) => u.value = o), size: e.size, disabled: e.firmNatureDisabled, multiple: e.multiple, "collapse-tags": e.collapseTags, clearable: e.firmNatureClearable, showOptionAll: e.showOptionAll, showExtra: e.showExtra, disabledVal: e.disabledVal, filterable: "", placeholder: e.firmNaturePlaceholder, options: N.value, onChange: B, class: "filter-item" }), null, 16, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "clearable", "showOptionAll", "showExtra", "disabledVal", "placeholder", "options"])) : C("", true), e.boolFirmType ? (i(), h(m, g({ key: 1 }, a.$attrs, { modelValue: d.value, "onUpdate:modelValue": l[1] || (l[1] = (o) => d.value = o), size: e.size, disabled: e.firmTypeDisabled, multiple: e.multiple, "collapse-tags": e.collapseTags, clearable: e.firmTypeClearable, showOptionAll: e.showOptionAll, showExtra: e.showExtra, disabledVal: e.disabledVal, filterable: "", placeholder: e.firmTypePlaceholder, options: I.value, onChange: O, class: "filter-item" }), null, 16, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "clearable", "showOptionAll", "showExtra", "disabledVal", "placeholder", "options"])) : C("", true), e.boolIndustry ? (i(), h(m, g({ key: 2 }, a.$attrs, { modelValue: s.value, "onUpdate:modelValue": l[2] || (l[2] = (o) => s.value = o), size: e.size, disabled: e.industryDisabled, multiple: e.multiple, "collapse-tags": e.collapseTags, clearable: e.industryClearable, showOptionAll: e.showOptionAll, showExtra: e.showExtra, disabledVal: e.disabledVal, filterable: "", placeholder: e.industryPlaceholder, options: V.value, onChange: v, class: "filter-item" }), null, 16, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "clearable", "showOptionAll", "showExtra", "disabledVal", "placeholder", "options"])) : C("", true), e.boolCorporateRepuration ? (i(), h(m, g({ key: 3 }, a.$attrs, { modelValue: f.value, "onUpdate:modelValue": l[3] || (l[3] = (o) => f.value = o), size: e.size, disabled: e.corporateRepurationDisabled, multiple: e.multiple, "collapse-tags": e.collapseTags, clearable: e.corporateRepurationClearable, showOptionAll: e.showOptionAll, showExtra: e.showExtra, disabledVal: e.disabledVal, filterable: "", placeholder: e.corporateRepurationPlaceholder, options: w.value, onChange: R, class: "filter-item" }), null, 16, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "clearable", "showOptionAll", "showExtra", "disabledVal", "placeholder", "options"])) : C("", true)], 64);
  };
} };
export {
  P as _
};
