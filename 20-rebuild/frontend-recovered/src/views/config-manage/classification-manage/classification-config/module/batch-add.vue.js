import { useStore as ee } from "vuex";
import { ref as N } from "vue";
import { reactive as J } from "vue";
import { computed as Q } from "vue";
import { watch as T } from "vue";
import { openBlock as x } from "vue";
import { createBlock as v } from "vue";
import { withCtx as h } from "vue";
import { createElementVNode as W } from "vue";
import { toDisplayString as K } from "vue";
import { createElementBlock as te } from "vue";
import { createCommentVNode as z } from "vue";
import { ElCascader as ae } from "element-plus";
import { onMounted as le } from "vue";
import { nextTick as oe } from "vue";
import { resolveComponent as I } from "vue";
import { createVNode as i } from "vue";
import { unref as V } from "vue";
import { createTextVNode as se } from "vue";
import { withModifiers as ne } from "vue";
import { isRef as re } from "vue";
import { ElMessage as H } from "element-plus";
import { ElTableColumn as de } from "element-plus";
import { ElInput as ie } from "element-plus";
import { ElForm as ce } from "element-plus";
import { _ as X, m as ue, b as E, i as G, u as me, o as pe, b4 as fe, cJ as he, aw as be, V as ge, cL as ye } from "../../../../../shared/runtime.js";
import { u as _e } from "../../../../../modules/use-table-operate-4f84437f.js";
import { u as Ve } from "../../../../../modules/use-add-form-local-storage-75741656.js";
const xe = { key: 0, style: { float: "right", color: "#8492a6", "font-size": "13px", "padding-left": "6px" } }, we = { __name: "index", props: { modelValue: { type: [Array, Number, String], default: "" }, disabledVal: { type: Array, default: () => [] }, basicClass: { type: Number, default: void 0 }, showSubjectCode: { type: Boolean, default: true }, size: { type: String, default: "default" }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, showAllLevels: { type: Boolean, default: false }, separator: { type: String, default: "/" }, collapseTags: { type: Boolean, default: true }, placeholder: { type: String, default: "可搜索：科目名称、编码" }, multiple: { type: Boolean, default: false }, checkStrictly: { type: Boolean, default: false }, emitPath: { type: Boolean, default: false }, deep: { type: Number, default: void 0 }, onlyShowCurrentDeep: { type: Boolean, default: false }, showExtra: { type: Boolean, default: false }, extraOptionLabel: { type: String, default: "同上" }, extraOptionValue: { type: [Number, String, Array, Boolean], default: -1 } }, emits: ["change", "update:modelValue"], setup(f, { expose: R, emit: $ }) {
  const L = $, a = f, w = ee(), C = N(), l = N(), o = J({ tree: [], treeOrigin: [] }), F = N(true), { clsTree: k } = ue("clsTree"), y = Q(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: a.emitPath, multiple: a.multiple, checkStrictly: a.checkStrictly }));
  T([() => k.value, () => a.basicClass], ([e]) => {
    j(e);
  }, { deep: true, immediate: true }), T(() => a.modelValue, (e) => {
    e instanceof Array ? l.value = [...e] : l.value = e, B(e);
  }, { immediate: true }), T(() => a.disabledVal, () => {
    A(o.tree);
  }, { immediate: true, deep: true }), E(k.value) && w.dispatch("config/fetchClassificationTree");
  function M(e, t) {
    const { data: c, pathLabels: n } = e, _ = t.length;
    if (_ === 0) return true;
    const u = c.name.includes(t), r = n.includes(t), m = c.code && c.code.substr(0, _) === t;
    return u || r || m;
  }
  function B(e) {
    let t = e !== a.modelValue;
    e instanceof Array && (t = !e.equals(a.modelValue));
    const c = E(e) && E(a.modelValue);
    return t && !c ? (L("update:modelValue", e), L("change", e), true) : false;
  }
  function j(e) {
    try {
      e ? (o.treeOrigin = e, o.tree = O(e.filter((t) => !a.basicClass || t.basicClass === a.basicClass)), a.showExtra && o.tree.unshift({ id: a.extraOptionValue, name: a.extraOptionLabel })) : (o.treeOrigin = [], o.tree = []);
    } catch (t) {
      console.log("获取科目级联列表失败", t);
    } finally {
      F.value = false;
    }
  }
  function O(e, t = 1) {
    if (E(a.deep) || t <= a.deep) {
      const c = e.map((n) => {
        let _ = 1;
        const u = { id: n.id, name: n.name, disabled: false };
        if (G(n.children)) {
          const r = O(n.children, t + 1);
          G(r) && (_++, u.children = r);
        }
        return u.maxDeep = _, u;
      });
      return t === 1 && a.onlyShowCurrentDeep ? c.filter((n) => n.maxDeep >= a.deep) : c;
    } else return [];
  }
  function A(e) {
    e.forEach((t) => (a.disabledVal.includes(t.id) ? (t.disabled = true, t.initDisabled = true) : (t.disabled = false, t.initDisabled = false), G(t.children) && A(t.children), t));
  }
  function q() {
    const e = C.value.getCheckedNodes(true);
    return e.length ? e[0].data : {};
  }
  function U(e) {
    return e.parent ? U(e.parent) : e;
  }
  return R({ getNodeInfo: q, getParentNode: U }), (e, t) => {
    const c = ae;
    return x(), v(c, { ref_key: "cascaderRef", ref: C, class: "classification-cascader", modelValue: l.value, "onUpdate:modelValue": t[0] || (t[0] = (n) => l.value = n), placeholder: f.placeholder, options: o.tree, props: y.value, "show-all-levels": f.showAllLevels, separator: f.separator, clearable: f.clearable, disabled: f.disabled, "collapse-tags": f.collapseTags, filterable: "", size: f.size, "filter-method": M, onChange: B }, { default: h(({ data: n }) => [W("span", null, K(n.name), 1), f.showSubjectCode ? (x(), te("span", xe, K(n.serialNumber), 1)) : z("", true)]), _: 1 }, 8, ["modelValue", "placeholder", "options", "props", "show-all-levels", "separator", "clearable", "disabled", "collapse-tags", "size"]);
  };
} }, Ce = X(we, [["__scopeId", "data-v-1532ec3b"]]);
const ve = { class: "header-operate" }, Le = { __name: "batch-add", props: { modelValue: { type: Boolean, require: true }, level: { type: Number, default: 1 } }, emits: ["success", "update:modelValue"], setup(f, { emit: R }) {
  const $ = [{ K: 2, V: 2, L: "二级" }, { K: 3, V: 3, L: "三级" }], L = R, a = f, w = N(false), C = N(true), l = J({ currentLevel: 1, list: [] }), o = { common: { name: [{ required: true, max: 20, message: "不能超过20个字符", trigger: "blur" }], code: [{ required: true, max: 3, message: "不能超过3个字符", trigger: "blur" }] }, LV1: { basicClass: [{ required: true, message: "请选择材料类型", trigger: "change" }] }, LV2: { parentId: [{ required: true, message: "请选择上级科目", trigger: "change" }] }, LV3: { parentId: [{ required: true, message: "请选择上级科目", trigger: "change" }] } }, F = Q(() => o[`LV${l.currentLevel}`]), k = /* @__PURE__ */ new Map([["basicClass", -1], ["parentId", -1]]), { visible: y, handleClose: M } = me({ emit: L, props: a }), { init: B, addRow: j, removeRow: O } = _e({}, 10, k), { tableValidate: A, cleanUpData: q, wrongCellMask: U } = be({ rules: F, ditto: k }), { ADD_FORM: e, clearFormStorage: t } = Ve("CLASSIFICATION_CONFIG", l, y);
  e.init = () => B(l.list);
  const { maxHeight: c } = pe({ mainBox: ".cls-batch-add", extraBox: [".el-dialog__header", ".header-operate"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, y);
  T(() => a.level, (u) => {
    l.currentLevel = u, n();
  }, { immediate: true }), le(() => {
    o.LV1 = Object.assign(o.LV1, o.common), o.LV2 = Object.assign(o.LV2, o.common), o.LV3 = Object.assign(o.LV3, o.common);
  });
  function n() {
    B(l.list), C.value = false, oe(() => {
      C.value = true;
    });
  }
  async function _() {
    try {
      w.value = true;
      const { validResult: u, dealList: r } = A(l.list);
      if (l.list = r, u) {
        const m = q(ge(r)), D = {}, p = [];
        for (let d = 0; d < m.length; d++) D[m[d].code] || (p.push(m[d]), D[m[d].code] = true);
        for (let d = 0; d < p.length; d++) {
          const b = m.filter((S) => S.parentId === p[d].parentId && (S.name === p[d].name || S.code === p[d].code));
          if (b.length > 1) {
            if (b[0].name === b[1].name) {
              H.error(`名称${b[0].name}相同`);
              return;
            }
            if (b[0].code === b[1].code) {
              H.error(`科目代码${b[0].code}相同`);
              return;
            }
          }
        }
        await ye(m), t(), L("success"), H.success("添加成功"), M();
      }
    } catch (u) {
      console.log("科目添加", u);
    } finally {
      w.value = false;
    }
  }
  return (u, r) => {
    const m = I("common-button"), D = I("common-radio-button"), p = de, d = ie, b = I("common-select"), S = I("common-table"), Y = ce, Z = I("common-dialog");
    return x(), v(Z, { modelValue: V(y), "onUpdate:modelValue": r[2] || (r[2] = (s) => re(y) ? y.value = s : null), "before-close": V(M), "close-on-click-modal": false, "show-close": true, "custom-class": "cls-batch-add", title: "新增科目", top: "10vh", width: "800px" }, { titleRight: h(() => [i(m, { size: "default", type: "success", icon: "el-icon-plus", onClick: r[0] || (r[0] = (s) => V(j)(l.list)) }), i(m, { loading: w.value, type: "primary", size: "default", onClick: _ }, { default: h(() => r[3] || (r[3] = [se("提 交")])), _: 1, __: [3] }, 8, ["loading"]), i(fe, { type: "normal" })]), default: h(() => [W("div", ve, [i(D, { modelValue: l.currentLevel, "onUpdate:modelValue": r[1] || (r[1] = (s) => l.currentLevel = s), options: $, type: "enum", size: "default", onChange: n }, null, 8, ["modelValue"])]), i(Y, { ref: "formRef", disabled: w.value, model: l }, { default: h(() => [C.value ? (x(), v(S, { key: 0, ref: "table", "cell-class-name": V(U), data: l.list, "max-height": V(c), "show-empty-symbol": false, "default-expand-all": "", "empty-text": "暂无数据", "return-source-data": "", "row-key": "uid" }, { default: h(() => [i(p, { align: "center", label: "序号", type: "index", width: "60" }), l.currentLevel > 1 ? (x(), v(p, { key: "parentId", "show-overflow-tooltip": true, label: "上级科目", "min-width": "150", prop: "parentId" }, { default: h(({ row: s, $index: g }) => [i(Ce, { modelValue: s.parentId, "onUpdate:modelValue": (P) => s.parentId = P, deep: l.currentLevel - 1, showExtra: g !== 0, clearable: "", "only-show-current-deep": "", placeholder: "上级科目", size: "default", separator: " > ", "show-all-levels": "", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "deep", "showExtra"])]), _: 1 })) : z("", true), i(p, { key: "name", "show-overflow-tooltip": true, label: "科目名称", "min-width": "150", prop: "name" }, { default: h(({ row: s }) => [i(d, { modelValue: s.name, "onUpdate:modelValue": (g) => s.name = g, modelModifiers: { trim: true }, type: "text", clearable: "", placeholder: "科目名称", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), i(p, { key: "code", "show-overflow-tooltip": true, label: "科目代码", prop: "code", width: "125" }, { default: h(({ row: s }) => [i(d, { modelValue: s.code, "onUpdate:modelValue": (g) => s.code = g, modelModifiers: { trim: true }, type: "text", maxlength: "3", size: "default", placeholder: "科目代码", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l.currentLevel == 1 ? (x(), v(p, { key: "basicClass", "show-overflow-tooltip": true, label: "材料类型", prop: "basicClass", width: "128" }, { default: h(({ row: s, $index: g }) => [(x(), v(b, { key: Math.random(), modelValue: s.basicClass, "onUpdate:modelValue": (P) => s.basicClass = P, options: V(he).ENUM, "show-extra": g !== 0, placeholder: "材料类型", style: { width: "105px" }, type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"]))]), _: 1 })) : z("", true), i(p, { align: "center", fixed: "right", label: "操作", width: "70px" }, { default: h(({ $index: s }) => [i(m, { icon: "el-icon-delete", size: "default", style: { padding: "6px" }, type: "danger", onClick: ne((g) => V(O)(l.list, s), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"])) : z("", true)]), _: 1 }, 8, ["disabled", "model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ne = X(Le, [["__scopeId", "data-v-445dabfe"]]);
export {
  Ne as default
};
