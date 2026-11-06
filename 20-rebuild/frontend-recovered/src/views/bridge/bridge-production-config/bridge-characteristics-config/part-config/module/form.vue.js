import { ref as k } from "vue";
import { watch as j } from "vue";
import { ElMessage as _ } from "element-plus";
import { nextTick as u } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as x } from "vue";
import { createBlock as E } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { createTextVNode as T } from "vue";
import { createElementVNode as g } from "vue";
import { ElInput as W } from "element-plus";
import { ElFormItem as G } from "element-plus";
import { ElSwitch as J } from "element-plus";
import { ElInputNumber as Q } from "element-plus";
import { ElDivider as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElForm as Z } from "element-plus";
import { _ as ee, au as V, ao as le, o as oe, am as f, V as ae, ap as se, av as te, aw as ne } from "../../../../../../shared/runtime.js";
const re = { class: "detail-header" }, de = { style: { "text-align": "center", "margin-top": "10px" } }, ie = { __name: "form", props: { boundAllClassifyIds: { type: Array, default: () => {
} } }, setup(L) {
  const I = L, h = k(), i = k([]), C = k(), y = k([]), P = { id: void 0, name: "", boolSectionSteel: V.FALSE.V, sort: void 0, links: [] }, { crud: c, form: o, CRUD: b } = le(P, h), { maxHeight: U } = oe({ extraBox: [".el-drawer__header", ".detail-header"], wrapperBox: [".el-drawer__body"], navbar: false, extraHeight: 120 }, () => C.value.loaded), A = { keyword: [{ required: true, message: "请输入大写字母", trigger: "blur" }] }, { tableValidate: O, wrongCellMask: R } = ne({ rules: A }), B = { name: [{ required: true, message: "请填写分类名称", trigger: "blur" }, { min: 1, max: 30, message: "长度在 1 到 30 个字符", trigger: "blur" }], sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }], classifyIds: [{ required: true, message: "请选择科目", trigger: "change" }] };
  j(() => o.basicClass, (l, e) => {
    e === f.STEEL_PLATE.V && (i.value = [], o.links = []), l === f.STEEL_PLATE.V && e && e !== f.STEEL_PLATE.V && (i.value = [], o.links = []), l && e && (o.classifyIds = []);
  });
  function z() {
    o.links.push({ add: true });
  }
  function F(l) {
    o.links.splice(l, 1);
  }
  function S(l, e) {
    const n = i.value.find((d) => d.index === e);
    if (n) if (l.keyword) {
      if (n.keyword === l.keyword) return;
      i.value.findIndex((d) => d.keyword === l.keyword) > -1 ? (_({ message: "关键字母已存在，请重新填写", type: "error" }), u(() => {
        o.links[e].keyword = void 0, n.keyword = void 0;
      })) : o.boolSectionSteel && l.keyword.substring(0, 1) === "P" ? (_({ message: "关键字母不能以P或PL开头，请重新填写", type: "error" }), u(() => {
        o.links[e].keyword = void 0, n.keyword = void 0;
      })) : u(() => {
        n.keyword = l.keyword;
      });
    } else u(() => {
      n.keyword = void 0;
    });
    else l.keyword && (i.value.findIndex((d) => d.keyword === l.keyword) > -1 && (_({ message: "关键字母已存在，请重新填写", type: "error" }), u(() => {
      l.keyword = void 0;
    })), o.boolSectionSteel && l.keyword.substring(0, 1) === "P" && (_({ message: "关键字母不能以P或PL开头，请重新填写", type: "error" }), u(() => {
      l.keyword = void 0;
    })), l.keyword && i.value.push({ keyword: l.keyword, index: e }));
  }
  return b.HOOK.beforeSubmit = (l, e) => {
    if (l.form.links && l.form.links.length === 0) return _.error("请填写零件规格前缀明细"), false;
    const { validResult: n, dealList: d } = O(l.form.links);
    if (n) l.form.links = d;
    else return n;
    l.form.specPrefixList = l.form.links.map((p) => p.keyword);
  }, b.HOOK.beforeToAdd = () => {
    i.value = [];
  }, b.HOOK.beforeToEdit = () => {
    i.value = [], o.links.map((l, e) => {
      i.value.push({ keyword: l.keyword });
    });
  }, b.HOOK.beforeToCU = () => {
    u(() => {
      y.value = ae(I.boundAllClassifyIds), o.classifyIds && o.classifyIds.forEach((l) => {
        const e = y.value.indexOf(l);
        e !== -1 && y.value.splice(e, 1);
      });
    });
  }, (l, e) => {
    const n = w("common-button"), d = W, p = G, H = J, M = Q, N = X, v = Y, $ = w("common-select"), K = w("common-table"), q = Z, D = w("common-drawer");
    return x(), E(D, { "append-to-body": "", "close-on-click-modal": false, "before-close": a(c).cancelCU, visible: a(c).status.cu > 0, title: a(c).status.title, "wrapper-closable": false, ref_key: "drawerRef", ref: C, size: "60%" }, { titleRight: r(() => [t(n, { loading: a(c).status.cu === 2, type: "primary", size: "default", onClick: a(c).submitCU }, { default: r(() => e[4] || (e[4] = [T("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), content: r(() => [t(q, { ref_key: "formRef", ref: h, model: a(o), rules: B, size: "default", "label-width": "140px" }, { default: r(() => [g("div", re, [t(p, { label: "名称", prop: "name" }, { default: r(() => [t(d, { modelValue: a(o).name, "onUpdate:modelValue": e[0] || (e[0] = (s) => a(o).name = s), type: "text", placeholder: "分类名称", style: { width: "270px" }, maxlength: "30" }, null, 8, ["modelValue"])]), _: 1 }), t(p, { label: "是否型材", prop: "classifyLinks" }, { default: r(() => [t(H, { modelValue: a(o).boolSectionSteel, "onUpdate:modelValue": e[1] || (e[1] = (s) => a(o).boolSectionSteel = s), "active-value": a(V).TRUE.V, "inactive-value": a(V).FALSE.V, class: "drawer-switch" }, null, 8, ["modelValue", "active-value", "inactive-value"]), e[5] || (e[5] = g("br", null, null, -1)), t(se, { modelValue: a(o).classifyIds, "onUpdate:modelValue": e[2] || (e[2] = (s) => a(o).classifyIds = s), "basic-class": a(o).boolSectionSteel ? a(f).SECTION_STEEL.V : a(f).STEEL_PLATE.V, multiple: "", "collapse-tags": false, separator: " > ", clearable: "", disabledVal: y.value, placeholder: "请选择科目", size: "default", style: { width: "270px" } }, null, 8, ["modelValue", "basic-class", "disabledVal"])]), _: 1, __: [5] }), t(p, { label: "排序", prop: "sort" }, { default: r(() => [t(M, { modelValue: a(o).sort, "onUpdate:modelValue": e[3] || (e[3] = (s) => a(o).sort = s), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(N, null, { default: r(() => e[6] || (e[6] = [g("span", { class: "title" }, "零件规格前缀明细", -1)])), _: 1, __: [6] })]), t(K, { ref: "detailRef", border: "", data: a(o).links, "max-height": a(U), style: { width: "100%", "margin-top": "10px" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "cell-class-name": a(R) }, { default: r(() => [t(v, { label: "序号", type: "index", align: "center", width: "55" }), t(v, { key: "keyword", prop: "keyword", label: "*大写字母", align: "center" }, { default: r((s) => [a(o).basicClass === a(f).STEEL_PLATE.V ? (x(), E($, { key: 0, modelValue: s.row.keyword, "onUpdate:modelValue": (m) => s.row.keyword = m, options: a(te).ENUM, type: "enum", size: "default", clearable: "", class: "filter-item", placeholder: "大写字母", onChange: (m) => S(s.row, s.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (x(), E(d, { key: 1, modelValue: s.row.keyword, "onUpdate:modelValue": (m) => s.row.keyword = m, modelModifiers: { trim: true }, type: "text", placeholder: "大写字母", maxlength: "20", onBlur: (m) => S(s.row, s.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"]))]), _: 1 }), t(v, { label: "操作", align: "center" }, { default: r((s) => [t(n, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (m) => F(s.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), g("div", de, [t(n, { size: "default", type: "success", onClick: z }, { default: r(() => e[7] || (e[7] = [T("添加")])), _: 1, __: [7] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, fe = ee(ie, [["__scopeId", "data-v-0b3d5db1"]]);
export {
  fe as default
};
