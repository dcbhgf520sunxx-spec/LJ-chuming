import { computed as I } from "vue";
import { ref as x } from "vue";
import { watchEffect as Q } from "vue";
import { ElMessage as P } from "element-plus";
import { nextTick as X } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as m } from "vue";
import { createBlock as p } from "vue";
import { withCtx as r } from "vue";
import { createVNode as i } from "vue";
import { unref as a } from "vue";
import { createTextVNode as g } from "vue";
import { createElementVNode as L } from "vue";
import { toDisplayString as k } from "vue";
import { ElTag as ee } from "element-plus";
import { ElFormItem as se } from "element-plus";
import { ElInputNumber as te } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElForm as ae } from "element-plus";
import { _ as oe, f9 as y, eu as O, au as T, ao as ne, o as re, V as ie, aw as de } from "../../../../../shared/runtime.js";
import { u as ce } from "../../../../../modules/use-section-all-504a2069.js";
const ue = { class: "detail-header" }, fe = { class: "add-row-box" }, me = { __name: "form", props: { boundAllClassifyIds: { type: Array, default: () => [] } }, setup(U) {
  const { loaded: C, assembleSectionAll: V } = ce(), R = I(() => {
    var l;
    const e = t.boolSectionSteel ? y.SECTION_PRODUCT.V : y.ASSEMBLE.V;
    return ((l = V.value[O.PRODUCT_TYPE_ENUM.V].find((n) => Number(n.productClassificationEnum) === e)) == null ? void 0 : l.sectionWarehouseConfigDTOList) || [];
  }), A = I(() => {
    var l;
    const e = t.boolSectionSteel ? y.SECTION_PRODUCT.V : y.ASSEMBLE.V;
    return ((l = V.value[O.SECTION_TYPE_ENUM.V].find((n) => Number(n.productClassificationEnum) === e)) == null ? void 0 : l.sectionWarehouseConfigDTOList) || [];
  }), h = x(), d = x([]), w = x(), N = { id: void 0, name: "", boolSectionSteel: T.FALSE.V, sort: void 0, assembleSpecList: [] }, z = U, S = x([]), K = { 0: { L: "全部", K: "0", V: 0 }, 1: { L: "1", K: "1", V: 1 }, 2: { L: "2", K: "2", V: 2 }, 3: { L: "3", K: "3", V: 3 }, 4: { L: "4", K: "4", V: 4 } }, { crud: c, form: t, CRUD: f } = ne(N, h), $ = { name: [{ required: true, message: "请填写代表部件类型名称", trigger: "change" }], sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }] };
  Q([() => t.classifyIds, () => t.boolSectionSteel], ([e, s]) => {
    s === true ? t.classifyIds = e : t.classifyIds = [];
  });
  const { maxHeight: B } = re({ extraBox: [".el-drawer__header", ".detail-header"], wrapperBox: [".el-drawer__body", ".table-form"], navbar: false, extraHeight: 120 }, () => w.value.loaded), F = { specPrefix: [{ required: true, message: "请输入部件号规格前缀", trigger: "blur" }], specIndex: [{ required: true, message: "请选择索引", trigger: "blur" }] }, { tableValidate: H, wrongCellMask: M } = de({ rules: F });
  function D() {
    t.assembleSpecList.push({ add: true, specIndex: 0 });
  }
  function q(e) {
    t.assembleSpecList.splice(e, 1);
  }
  function W(e, s) {
    e.specPrefix = void 0;
    const l = d.value.findIndex((n) => n.index === s);
    d.value.splice(l, 1);
  }
  function Y(e, s) {
    const l = d.value.find((n) => n.index === s);
    if (l) if (e.specPrefix) {
      if (l.specPrefix === e.specPrefix) return;
      if (d.value.findIndex((n) => n.specPrefix === e.specPrefix) > -1) P({ message: "规格前缀已存在，请重新选择", type: "error" }), e.specPrefix = void 0, l.specPrefix = void 0;
      else {
        if (!/^[\u4e00-\u9fa5A-Z]+$/.test(e.specPrefix)) {
          t.assembleSpecList[s].specPrefix = void 0, l.specPrefix = void 0;
          return;
        }
        l.specPrefix = e.specPrefix;
      }
    } else l.specPrefix = void 0;
    else if (e.specPrefix) {
      if (!/^[\u4e00-\u9fa5A-Z]+$/.test(e.specPrefix)) {
        t.assembleSpecList[s].specPrefix = void 0;
        return;
      }
      d.value.findIndex((n) => n.specPrefix === e.specPrefix) > -1 && (P({ message: "规格前缀已存在，请重新选择", type: "error" }), t.assembleSpecList[s].specPrefix = void 0), d.value.push({ specPrefix: e.specPrefix, index: s });
    }
  }
  return f.HOOK.beforeValidateCU = (e, s) => {
    if (e.form.assembleSpecList && e.form.assembleSpecList.length === 0) return P.error("请填写部件号规格前缀明细"), false;
    const { validResult: l, dealList: n } = H(e.form.assembleSpecList);
    if (l) e.form.assembleSpecList = n;
    else return l;
  }, f.HOOK.beforeToAdd = () => {
    d.value = [];
  }, f.HOOK.beforeToEdit = () => {
    d.value = [], t.assembleSpecList.map((e, s) => {
      d.value.push({ specPrefix: e.specPrefix, index: s });
    });
  }, f.HOOK.beforeToCU = () => {
    X(() => {
      S.value = ie(z.boundAllClassifyIds), t.classifyIds && t.classifyIds.forEach((e) => {
        const s = S.value.indexOf(e);
        s !== -1 && S.value.splice(s, 1);
      });
    });
  }, f.HOOK.beforeSubmit = () => {
    t.mesProductEnum = c.query.mesProductEnum;
  }, (e, s) => {
    const l = _("common-button"), n = ee, v = _("common-select"), E = se, Z = te, b = le, j = _("common-table"), G = ae, J = _("common-drawer");
    return m(), p(J, { "append-to-body": "", "close-on-click-modal": false, "before-close": a(c).cancelCU, visible: a(c).status.cu > 0, title: a(c).status.title, "wrapper-closable": false, ref_key: "drawerRef", ref: w, size: "650px" }, { titleRight: r(() => [i(l, { loading: a(c).status.cu === 2, type: "primary", size: "default", onClick: a(c).submitCU }, { default: r(() => s[4] || (s[4] = [g("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), content: r(() => [i(G, { ref_key: "formRef", ref: h, model: a(t), rules: $, size: "default", "label-width": "140px" }, { default: r(() => [L("div", ue, [i(E, { label: "代表部件类型", prop: "name" }, { default: r(() => [a(t).name ? (m(), p(n, { key: 0, style: { "margin-right": "3px", "margin-bottom": "3px" }, closable: "", "disable-transitions": false, size: "large", effect: "plain", onClose: s[0] || (s[0] = (o) => a(t).name = void 0) }, { default: r(() => [g(k(a(t).name), 1)]), _: 1 })) : (m(), p(v, { key: 1, modelValue: a(t).name, "onUpdate:modelValue": s[1] || (s[1] = (o) => a(t).name = o), options: R.value, type: "other", size: "default", dataStructure: { key: "name", label: "name", value: "name" }, placeholder: "代表部件类型", style: { width: "250px" }, disabled: !a(C) }, null, 8, ["modelValue", "options", "disabled"]))]), _: 1 }), i(E, { label: "排序", prop: "sort" }, { default: r(() => [i(Z, { modelValue: a(t).sort, "onUpdate:modelValue": s[2] || (s[2] = (o) => a(t).sort = o), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), i(j, { ref: "detailRef", border: "", data: a(t).assembleSpecList, "max-height": a(B), style: { width: "100%", "margin-top": "10px" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "cell-class-name": a(M) }, { default: r(() => [i(b, { label: "序号", type: "index", align: "center", width: "55" }), i(b, { key: "specPrefix", prop: "specPrefix", label: "部件规格前缀(大写字母或中文)", align: "center" }, { default: r((o) => [o.row.specPrefix ? (m(), p(n, { key: 0, style: { "margin-right": "3px", "margin-bottom": "3px" }, closable: "", "disable-transitions": false, size: "large", effect: "plain", onClose: (u) => W(o.row, o.$index) }, { default: r(() => [g(k(o.row.specPrefix), 1)]), _: 2 }, 1032, ["onClose"])) : (m(), p(v, { key: 1, modelValue: o.row.specPrefix, "onUpdate:modelValue": (u) => o.row.specPrefix = u, options: A.value, type: "other", size: "default", class: "filter-item", dataStructure: { key: "name", label: "name", value: "name" }, placeholder: "请选择", style: { width: "100%" }, filterable: "", onChange: (u) => Y(o.row, o.$index), disabled: !a(C) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange", "disabled"]))]), _: 1 }), i(b, { key: "specIndex", prop: "specIndex", label: "索引", align: "center" }, { default: r((o) => [i(v, { modelValue: o.row.specIndex, "onUpdate:modelValue": (u) => o.row.specIndex = u, options: K, type: "enum", size: "default", disabled: a(t).boolSectionSteel === a(T).FALSE.V, clearable: "", class: "filter-item", placeholder: "索引" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), i(b, { label: "操作", align: "center", width: "100" }, { default: r((o) => [i(l, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (u) => q(o.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), L("div", fe, [i(l, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-top": "15px" }, onClick: s[3] || (s[3] = (o) => D()) }, { default: r(() => s[5] || (s[5] = [g(" 添加 ")])), _: 1, __: [5] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, _e = oe(me, [["__scopeId", "data-v-6190846f"]]);
export {
  _e as default
};
