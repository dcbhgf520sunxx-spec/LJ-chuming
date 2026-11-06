import { computed as c } from "vue";
import { ref as _ } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as d } from "vue";
import { createBlock as p } from "vue";
import { withCtx as n } from "vue";
import { createVNode as u } from "vue";
import { unref as a } from "vue";
import { createTextVNode as V } from "vue";
import { withModifiers as Q } from "vue";
import { toDisplayString as U } from "vue";
import { createCommentVNode as X } from "vue";
import { createElementBlock as Z } from "vue";
import { Fragment as ee } from "vue";
import { renderList as re } from "vue";
import { ElMessage as O } from "element-plus";
import { nextTick as L } from "vue";
import { ElFormItem as ae } from "element-plus";
import { ElTag as te } from "element-plus";
import { ElInputNumber as ie } from "element-plus";
import { ElForm as se } from "element-plus";
import { _ as le, eu as y, f9 as A, es as b, ao as oe, fa as ne, i as g, au as ue, f5 as me } from "../../../../../shared/runtime.js";
import { u as de } from "../../../../../modules/use-section-all-504a2069.js";
const fe = { __name: "form", setup(ce) {
  const { loaded: v, artifactSectionAll: x } = de(), R = c(() => {
    var e, t, s;
    return ((s = (t = (e = x.value) == null ? void 0 : e[y.PRODUCT_NAME.V]) == null ? void 0 : t.find((l) => Number(l.productClassificationEnum) === A.PRIMARY_MEMBER.V)) == null ? void 0 : s.sectionWarehouseConfigDTOList) || [];
  }), w = c(() => {
    var e, t, s;
    return ((s = (t = (e = x.value) == null ? void 0 : e[y.PRODUCT_NAME.V]) == null ? void 0 : t.find((l) => Number(l.productClassificationEnum) === A.SECONDARY_MEMBER.V)) == null ? void 0 : s.sectionWarehouseConfigDTOList) || [];
  }), D = c(() => {
    var e, t, s;
    return ((s = (t = (e = x.value) == null ? void 0 : e[y.PRODUCT_TYPE_ENUM.V]) == null ? void 0 : t.find((l) => Number(l.productClassificationEnum) === A.PRIMARY_MEMBER.V)) == null ? void 0 : s.sectionWarehouseConfigDTOList) || [];
  }), z = c(() => {
    var e, t, s;
    return ((s = (t = (e = x.value) == null ? void 0 : e[y.PRODUCT_TYPE_ENUM.V]) == null ? void 0 : t.find((l) => Number(l.productClassificationEnum) === A.SECONDARY_MEMBER.V)) == null ? void 0 : s.sectionWarehouseConfigDTOList) || [];
  }), B = c(() => {
    var e, t;
    return ((t = (e = x.value) == null ? void 0 : e[y.SECTION_TYPE_ENUM.V][0]) == null ? void 0 : t.sectionWarehouseConfigDTOList) || [];
  }), I = { artifactType: b.COMMON.V, serialNumberPrefixArr: [], classificationName: void 0, specPrefixArr: [], smallArtifactClassEnum: void 0, codingType: void 0, boolComposeAssemble: void 0, sort: 1 }, q = { artifactType: [{ required: true, message: "请选择构件类型", trigger: "change" }], classificationName: [{ required: true, message: "请选择构件类型", trigger: "change" }], specPrefixArr: [{ required: true, message: "请选择规格前缀", trigger: "change" }], smallArtifactClassEnum: [{ required: true, message: "请选择次构件类型", trigger: "change" }], codingType: [{ required: true, message: "请选择打码方式", trigger: "change" }] }, h = _(), F = c(() => m.status.edit >= 1), { CRUD: E, crud: m, form: r } = oe(I, h), k = _(false), N = _(), T = _(false), f = _(), Y = c(() => m.query.mesProductEnum === ne.BRIDGE.V ? [b.SMALL.V] : []);
  function W() {
    m.form.serialNumberPrefixArr = [], m.form.classificationName = void 0, m.form.specPrefixArr = [], m.form.smallArtifactClassEnum = void 0;
  }
  E.HOOK.beforeSubmit = () => {
    const o = [], e = [];
    g(r.serialNumberPrefixArr) && r.serialNumberPrefixArr.forEach((t) => {
      var s;
      o.push({ id: g(r.serialNumberPrefixList) ? (s = r.serialNumberPrefixList.find((l) => l.serialNumberPrefix === t.serialNumberPrefix)) == null ? void 0 : s.id : void 0, serialNumberPrefix: t });
    }), r.serialNumberPrefixList = o, g(r.specPrefixArr) && r.specPrefixArr.forEach((t) => {
      var s;
      e.push({ id: g(r.specPrefixList) ? (s = r.specPrefixList.find((l) => l.specPrefix === t.specPrefix)) == null ? void 0 : s.id : void 0, specPrefix: t });
    }), r.specPrefixList = F.value ? e : r.specPrefixArr, r.mesProductEnum = m.query.mesProductEnum;
  }, E.HOOK.beforeToCU = () => {
    M(1), M(2);
  };
  function M(o) {
    switch (o) {
      case 1:
        k.value = false, N.value = void 0;
        break;
      case 2:
        T.value = false, f.value = void 0;
        break;
    }
  }
  function $(o, e) {
    if (e.length === 1) {
      O.warning("至少保留一条数据");
      return;
    }
    e.splice(e.indexOf(o), 1);
  }
  function G(o) {
    switch (o) {
      case 1:
        k.value = true;
        break;
      case 2:
        T.value = true;
        break;
    }
  }
  function H(o) {
    var e, t;
    if (o === 1) {
      if ((e = r.serialNumberPrefixArr) != null && e.includes(N.value)) {
        O.warning("数据已存在"), L(() => {
          N.value = void 0;
        });
        return;
      }
      g(N.value) && r.serialNumberPrefixArr.push(N.value);
    } else {
      if ((t = r.specPrefixArr) != null && t.includes(f.value)) {
        O.warning("数据已存在"), L(() => {
          f.value = void 0;
        });
        return;
      }
      g(f.value) && r.specPrefixArr.push(f.value);
    }
    M(o);
  }
  return (o, e) => {
    const t = C("common-button"), s = C("common-radio"), l = ae, S = te, P = C("common-select"), K = ie, j = se, J = C("common-dialog");
    return d(), p(J, { "append-to-body": "", "close-on-click-modal": false, "before-close": a(m).cancelCU, visible: a(m).status.cu > a(E).STATUS.NORMAL, title: a(m).status.title, width: "500px" }, { titleRight: n(() => [u(t, { loading: a(m).status.cu === a(E).STATUS.PROCESSING, size: "default", type: "primary", onClick: a(m).submitCU }, { default: n(() => e[11] || (e[11] = [V(" 确认 ")])), _: 1, __: [11] }, 8, ["loading", "onClick"])]), default: n(() => [u(j, { ref_key: "formRef", ref: h, model: a(r), rules: q, size: "default", "label-width": "100px", class: "tax-setting", onSubmit: e[10] || (e[10] = Q(() => {
    }, ["prevent"])) }, { default: n(() => [u(l, { label: "类型", prop: "artifactType" }, { default: n(() => [u(s, { modelValue: a(r).artifactType, "onUpdate:modelValue": e[0] || (e[0] = (i) => a(r).artifactType = i), disabledVal: Y.value, options: a(b).ENUM, type: "enum", size: "default", onChange: W }, null, 8, ["modelValue", "disabledVal", "options"])]), _: 1 }), u(l, { label: "构件类型", prop: "classificationName" }, { default: n(() => [a(r).classificationName ? (d(), p(S, { key: 0, style: { "margin-right": "3px", "margin-bottom": "3px" }, closable: "", "disable-transitions": false, size: "large", effect: "plain", onClose: e[1] || (e[1] = (i) => a(r).classificationName = void 0) }, { default: n(() => [V(U(a(r).classificationName), 1)]), _: 1 })) : (d(), p(P, { key: 1, modelValue: a(r).classificationName, "onUpdate:modelValue": e[2] || (e[2] = (i) => a(r).classificationName = i), options: a(r).artifactType === a(b).SMALL.V ? z.value : D.value, type: "other", size: "default", class: "filter-item", dataStructure: { key: "name", label: "name", value: "name" }, filterable: "", placeholder: "构件类型", style: { width: "250px" }, disabled: !a(v) }, null, 8, ["modelValue", "options", "disabled"]))]), _: 1 }), a(r).artifactType === a(b).SMALL.V ? (d(), p(l, { key: 0, label: "匹配名称", prop: "serialNumberPrefixArr" }, { default: n(() => [u(P, { modelValue: a(r).serialNumberPrefixArr, "onUpdate:modelValue": e[3] || (e[3] = (i) => a(r).serialNumberPrefixArr = i), options: a(r).artifactType === a(b).SMALL.V ? w.value : R.value, type: "other", size: "default", class: "filter-item", dataStructure: { key: "name", label: "name", value: "name" }, filterable: "", multiple: "", placeholder: "匹配名称", style: { width: "250px" }, disabled: !a(v) }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })) : X("", true), u(l, { label: "规格前缀", prop: "specPrefixArr" }, { default: n(() => [(d(true), Z(ee, null, re(a(r).specPrefixArr, (i) => (d(), p(S, { key: i, style: { "margin-right": "3px", "margin-bottom": "3px" }, closable: "", "disable-transitions": false, size: "large", effect: "plain", onClose: (pe) => $(i, a(r).specPrefixArr) }, { default: n(() => [V(U(i), 1)]), _: 2 }, 1032, ["onClose"]))), 128)), T.value ? (d(), p(P, { key: 0, modelValue: f.value, "onUpdate:modelValue": e[4] || (e[4] = (i) => f.value = i), options: B.value, type: "other", size: "default", class: "filter-item", dataStructure: { key: "name", label: "name", value: "name" }, placeholder: "规格前缀", filterable: "", style: { width: "250px" }, disabled: !a(v), onChange: e[5] || (e[5] = (i) => H(2)) }, null, 8, ["modelValue", "options", "disabled"])) : (d(), p(t, { key: 1, size: "default", onClick: e[6] || (e[6] = (i) => G(2)) }, { default: n(() => e[12] || (e[12] = [V(" + 新增 ")])), _: 1, __: [12] }))]), _: 1 }), u(l, { label: "是否需组立", prop: "boolComposeAssemble" }, { default: n(() => [u(P, { modelValue: a(r).boolComposeAssemble, "onUpdate:modelValue": e[7] || (e[7] = (i) => a(r).boolComposeAssemble = i), options: a(ue).ENUM, type: "enum", size: "default", class: "filter-item", clearable: "", placeholder: "是否需组立", style: { width: "250px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), u(l, { label: "打码方式", prop: "codingType" }, { default: n(() => [u(P, { modelValue: a(r).codingType, "onUpdate:modelValue": e[8] || (e[8] = (i) => a(r).codingType = i), options: a(me).ENUM, type: "enum", size: "default", class: "filter-item", placeholder: "打码方式", style: { width: "250px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), u(l, { label: "排序", prop: "sort" }, { default: n(() => [u(K, { modelValue: a(r).sort, "onUpdate:modelValue": e[9] || (e[9] = (i) => a(r).sort = i), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Ne = le(fe, [["__scopeId", "data-v-6ad39969"]]);
export {
  Ne as default
};
