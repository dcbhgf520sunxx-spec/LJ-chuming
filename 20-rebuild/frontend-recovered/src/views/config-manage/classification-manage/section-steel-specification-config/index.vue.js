import { ElNotification as K } from "element-plus";
import { ref as _ } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as c } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as E } from "vue";
import { toDisplayString as P } from "vue";
import { unref as i } from "vue";
import { ElUpload as J } from "element-plus";
import { Fragment as C } from "vue";
import { renderList as B } from "vue";
import { ElMessage as Z } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { computed as ee } from "vue";
import { provide as j } from "vue";
import { resolveDirective as te } from "vue";
import { withDirectives as W } from "vue";
import { createBlock as g } from "vue";
import { createCommentVNode as k } from "vue";
import { ElCheckTag as ae } from "element-plus";
import { ElTag as le } from "element-plus";
import { ElPopover as ie } from "element-plus";
import { vLoading as ne } from "element-plus";
import { c as se, a as oe, g as re, m as de, s as ce } from "./module/header.vue.js";
import { V as ue, i as F, cY as me, cZ as pe, c_ as N, c$ as Y, d0 as D, d1 as fe, _ as Q, aw as ge, o as X, d2 as _e, d3 as he, d4 as be, x as ye, cX as A, b as ve, G as we } from "../../../../shared/runtime.js";
import { b as xe, g as Ee, _ as Se } from "./detail/index.vue.js";
import { _ as ke } from "../../../../modules/index-f406fc4e.js";
import Ne from "./module/form.vue.js";
import "./detail/module/header.vue.js";
import "./detail/module/form.vue.js";
import "./detail/module/batch-form.vue.js";
import "../../../../modules/use-table-operate-4f84437f.js";
import "../../../../modules/specification-config-4ae0bc64.js";
const O = { title: "型材规格导入", dlgWidth: "500px", startRow: 2, fields: [{ label: "规格", field: "specification", excelField: "__EMPTY" }, { label: "单位净量(kg/m)", field: "unitNet", excelField: "__EMPTY_1" }], rules: { specification: [{ required: true, max: 20, message: "不能超过50个字符" }], unitNet: [{ required: true, min: 1, message: "重量最小为1" }] }, submitFormat: (y, h) => {
  const p = ue(y), e = [];
  return p.forEach((t, f) => {
    t.unitNet = Number(t.unitNet), typeof t.unitNet == "number" && !isNaN(t.unitNet) || e.push(f + 1);
  }), F(e) && K({ title: "序号" + e.join(",") + "单位净量必须为数值", type: "error" }), p.forEach((t) => {
    t.standard = [{ id: h.id, unitNet: t.unitNet ? Number(t.unitNet) : void 0 }], delete t.unitNet;
  }), F(e) ? [] : p;
}, submit: async (y, h, p) => {
  const e = O.submitFormat(y, p);
  F(e) && (await xe({ sectionSteelId: h.id, list: e }), K({ title: `${h.name}-${p.name}，规格导入成功`, type: "success" }));
} }, Ce = { fontUnit: "pt", unit: me.MM.V, unitPrecision: pe.ZERO.V, type: "SECTION_STEEL_SPEC_IMPL", name: "型材规格导出", width: 210, height: 297, paddingLR: 10, paddingTB: 10, title: { show: true, allPage: false, title: "型材-国标", align: N.CENTER.V, verticleAlign: Y.CENTER.V, size: 17, bold: "bold", height: 10 }, header: { show: true, allPage: false, align: N.LEFT.V, verticleAlign: Y.CENTER.V, size: 10, bold: "bold", height: 6, width: 190, emptyVal: "" }, table: { th: { size: 10, bold: "bold", lineHeight: 15, paddingTB: 1 }, td: { size: 9, bold: "unset", lineHeight: 13, paddingTB: 1 }, emptyVal: "/", index: { show: true, title: "序号", width: 10, align: N.CENTER.V }, summary: { show: false, title: "合计" }, extraFields: [{ key: "basicClass", title: "基础类型", type: D.ENUM.K, format: { enum: "rawMatClsEnum" } }], fields: [{ show: true, key: "specification", title: "规格", align: N.LEFT.V, minWidth: 18, type: D.SPECIFICATION.K }, { show: true, key: "unitNet", title: "单位净重(kg/m)", align: N.CENTER.V, minWidth: 15, type: D.QUANTITY.K, format: { toThousand: false }, sum: false }] }, page: { show: true, format: fe.DEFAULT.V, align: N.CENTER.V, size: 11, bold: "unset", bottom: 2 }, fetch: async (y) => await Ee(y) };
const Te = { __name: "index", props: { title: { type: String, default: "表格解析预览" }, template: { type: Object, required: true }, submitFn: { type: Function }, width: { type: [String, Number] }, accept: { type: String, default: ".xls,.xlsx" }, successMessage: { type: String, default: "上传成功" }, size: { type: String, default: "default" }, icon: { type: String, default: "el-icon-upload" }, btnName: { type: String, default: "上传" }, btnType: { type: String, default: "" }, btnSize: { type: String, default: "default" }, tip: { type: String, default: "" }, disabled: { type: Boolean, default: false }, limit: { type: Number, default: void 0 }, sizeLimit: { type: Number, default: void 0 } }, emits: ["success"], setup(y, { emit: h }) {
  const p = h, e = y, t = _(false), f = _(false), T = _([]), { tableValidate: R, cleanUpData: V, wrongCellMask: v } = ge({ rules: e.template.rules }), { maxHeight: S } = X({ mainBox: ".excel-resolve-preview", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, extraHeight: "15vh" }, t);
  async function H() {
    f.value = true;
    try {
      const { validResult: l, dealList: u } = R(T.value);
      l && (await e.submitFn ? e.submitFn(V(u)) : e.template.submit(V(u)), p("success", u), I());
    } catch (l) {
      console.log("科目添加", l);
    } finally {
      f.value = false;
    }
  }
  const I = () => {
    t.value = false;
  }, w = _(), L = _(false);
  function r(l) {
    return t.value = true, _e(l, { accept: e.accept, sizeLimit: e.sizeLimit }), true;
  }
  async function s(l, u) {
    try {
      t.value = true, L.value = true;
      const x = await he(l.raw);
      T.value = await be(x, e.template);
    } catch (x) {
      console.log("excel文件解析", x);
    } finally {
      L.value = false, m();
    }
  }
  function m() {
    w.value && w.value.uploadRef && (w.value.uploadRef.fileList.length = 0);
  }
  function $(l, u) {
    Z.warning(`当前限制选择 ${e.limit} 个文件，本次选择了 ${l.length} 个文件，共选择了 ${l.length + u.length} 个文件`);
  }
  return (l, u) => {
    const x = z("common-button"), M = G, U = z("common-table"), d = z("common-dialog");
    return n(), b("div", null, [c(i(J), { ref_key: "uploadRef", ref: w, class: "upload-excel-resolve", action: "", "before-upload": r, "on-change": s, "on-exceed": $, disabled: e.disabled, limit: e.limit, accept: e.accept, "auto-upload": false, "show-file-list": false }, { default: o(() => [c(x, { loading: L.value, disabled: e.disabled, icon: e.icon, size: e.btnSize, type: e.btnType }, { default: o(() => [E(P(e.btnName), 1)]), _: 1 }, 8, ["loading", "disabled", "icon", "size", "type"])]), _: 1 }, 8, ["disabled", "limit", "accept"]), c(d, { title: e.title, modelValue: t.value, "onUpdate:modelValue": u[0] || (u[0] = (a) => t.value = a), width: e.width || e.template.dlgWidth || "800px", "before-close": I, "show-close": true, "close-on-click-modal": false, "custom-class": "excel-resolve-preview", top: "10vh" }, { titleRight: o(() => [c(x, { loading: f.value, type: "primary", size: "default", onClick: H }, { default: o(() => u[1] || (u[1] = [E("提 交")])), _: 1, __: [1] }, 8, ["loading"])]), default: o(() => [c(U, { ref: "table", data: T.value, "empty-text": "暂无数据", "max-height": i(S), "cell-class-name": i(v), "default-expand-all": "", style: { width: "100%" } }, { default: o(() => [c(M, { label: "序号", type: "index", align: "center", width: "60" }), (n(true), b(C, null, B(e.template.fields, (a) => (n(), b(C, { key: a.field }, [E(P(a.name) + " ", 1), c(M, { prop: a.field, "show-overflow-tooltip": true, label: a.label }, null, 8, ["prop", "label"])], 64))), 128))]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])]), _: 1 }, 8, ["title", "modelValue", "width"])]);
  };
} }, Re = Q(Te, [["__scopeId", "data-v-76442790"]]);
const Ve = { class: "app-container section-steel" }, Le = { key: 0, style: { display: "flex", "justify-content": "flex-start" } }, $e = { __name: "index", setup(y) {
  const h = { add: false, edit: false, del: false, download: false }, p = _(), { CRUD: e, crud: t, columns: f } = ye({ title: "型材", permission: { ...A }, optShow: { ...h }, crudApi: { get: se.get, add: oe }, hasPagination: false }, p), { maxHeight: T } = X(), R = _(false), V = _({}), v = _([]), S = _(/* @__PURE__ */ new Map()), H = ee(() => !t.query || ve(t.query.name) ? t.data : t.data.filter((r) => r.name.indexOf(t.query.name) > -1));
  j("standard", v), j("sectionSteel", V), w(), e.HOOK.beforeRefresh = () => {
    w();
  }, e.HOOK.handleRefresh = (r, { data: s }) => {
    if (F(s.content)) {
      const m = ($) => {
        $.forEach((l) => {
          l.downloadLoading = false, F(l.children) ? m(l.children) : (delete l.children, l.isLeaf = true);
        });
      };
      m(s.content);
    }
  };
  function I(r) {
    V.value = r, R.value = true;
  }
  async function w() {
    try {
      v.value = await re() || [], S.value = /* @__PURE__ */ new Map(), v.value.forEach((r) => {
        S.value.set(r.id, r.name);
      });
    } catch (r) {
      console.log("获取国标", r);
    }
  }
  async function L(r, s) {
    if (r.standardId !== s) try {
      await ce(s, r.id), Z({ message: `【${r.name}】默认国标切换为【${S.value.get(s)}】`, type: "success" }), r.standardId = s, w();
    } catch (m) {
      console.log("切换国标", m);
    }
  }
  return (r, s) => {
    const m = G, $ = le, l = z("common-button"), u = ie, x = z("common-table"), M = te("permission"), U = ne;
    return n(), b("div", Ve, [c(i(de), { onRefresh: i(t).refresh }, null, 8, ["onRefresh"]), W((n(), g(x, { ref_key: "tableRef", ref: p, data: H.value, "show-empty-symbol": false, "return-source-data": "", "max-height": i(T), "default-expand-all": "", "row-key": "id", class: "tree-table", onSelectionChange: i(t).selectionChangeHandler }, { default: o(() => [c(m, { type: "selection", width: "55", align: "center" }), c(m, { label: "序号", type: "index", align: "center", width: "60" }), i(f).visible("serialNumber") ? (n(), g(m, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", label: "型材编号", align: "left", width: "150" })) : k("", true), i(f).visible("name") ? (n(), g(m, { key: "name", "show-overflow-tooltip": true, prop: "name", label: "型材名称", align: "left", width: "250" })) : k("", true), i(f).visible("standardId") ? (n(), g(m, { key: "standardId", "show-overflow-tooltip": true, prop: "standardId", label: "执行标准", align: "left" }, { default: o((d) => [d.row.isLeaf ? (n(), b(C, { key: 0 }, [i(we)(i(A).edit) ? (n(true), b(C, { key: 0 }, B(v.value, (a) => (n(), g(i(ae), { class: "check-tag", key: a.id, type: "success", checked: d.row.standardId === a.id, onClick: (q) => L(d.row, a.id) }, { default: o(() => [E(P(a.name), 1)]), _: 2 }, 1032, ["checked", "onClick"]))), 128)) : (n(), g($, { key: 1, type: "primary", size: "large" }, { default: o(() => [E(P(S.value.get(d.row.standardId)), 1)]), _: 2 }, 1024))], 64)) : k("", true)]), _: 1 })) : k("", true), i(f).visible("attachmentId") ? (n(), g(m, { key: "attachmentId", "show-overflow-tooltip": true, prop: "attachmentId", label: "操作", align: "left" }, { default: o((d) => [d.row.isLeaf ? (n(), b("div", Le, [c(l, { size: "default", type: "primary", icon: "el-icon-view", onClick: (a) => I(d.row) }, { default: o(() => s[1] || (s[1] = [E(" 查看 ")])), _: 2, __: [1] }, 1032, ["onClick"]), c(u, { placement: "right", title: "", trigger: "click", width: 150 }, { reference: o(() => [W((n(), g(l, { size: "default", icon: "el-icon-upload", type: "warning" }, { default: o(() => s[2] || (s[2] = [E("上传")])), _: 1, __: [2] })), [[M, i(A).add]])]), default: o(() => [(n(true), b(C, null, B(v.value, (a) => (n(), g(Re, { key: `import_${a.id}`, class: "resolve-btn", "btn-name": a.name, template: i(O), title: `${d.row.name}：${a.name}`, submitFn: (q) => i(O).submit(q, d.row, a), onSuccess: i(t).refresh }, null, 8, ["btn-name", "template", "title", "submitFn", "onSuccess"]))), 128))]), _: 2 }, 1024), c(u, { placement: "right", title: "", trigger: "click", width: 150 }, { reference: o(() => [c(l, { size: "default", icon: "el-icon-download", type: "success" }, { default: o(() => s[3] || (s[3] = [E("下载")])), _: 1, __: [3] })]), default: o(() => [(n(true), b(C, null, B(v.value, (a) => (n(), g(ke, { key: `export_${a.id}`, class: "resolve-btn", "btn-name": a.name, template: i(Ce), title: `${d.row.name}：${a.name}`, filename: `${d.row.name}_${a.name}规格清单`, params: { sectionSteelId: d.row.id, standardId: a.id } }, null, 8, ["btn-name", "template", "title", "filename", "params"]))), 128))]), _: 2 }, 1024)])) : k("", true)]), _: 1 })) : k("", true)]), _: 1 }, 8, ["data", "max-height", "onSelectionChange"])), [[U, i(t).loading]]), c(i(Ne)), c(Se, { visible: R.value, "onUpdate:visible": s[0] || (s[0] = (d) => R.value = d) }, null, 8, ["visible"])]);
  };
} }, qe = Q($e, [["__scopeId", "data-v-81d21bec"]]);
export {
  qe as default
};
