import { ref as y } from "vue";
import { watch as R } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as c } from "vue";
import { createBlock as V } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as w } from "vue";
import { createTextVNode as x } from "vue";
import { createVNode as e } from "vue";
import { unref as g } from "vue";
import { createElementBlock as I } from "vue";
import { createCommentVNode as Y } from "vue";
import { Fragment as Z } from "vue";
import { renderList as ee } from "vue";
import { toDisplayString as O } from "vue";
import { ElMessageBox as le } from "element-plus";
import { ElMessage as S } from "element-plus";
import { ElNotification as M } from "element-plus";
import { ElInput as ae } from "element-plus";
import { ElFormItem as te } from "element-plus";
import { ElCol as oe } from "element-plus";
import { ElRow as se } from "element-plus";
import { ElOption as ue } from "element-plus";
import { ElSelect as ne } from "element-plus";
import { ElTag as de } from "element-plus";
import { ElForm as re } from "element-plus";
import { ElButton as ie } from "element-plus";
import { _ as pe, m as me, au as _, th as ce, p as fe, z as ve, te as ye, ti as be, nw as ge, tj as _e } from "../../../../../../shared/runtime.js";
import P from "../../components/drawing-upload-btn.vue.js";
import "../../../../../../modules/index-ce9deea8.js";
const Ve = { style: { display: "flex", "margin-left": "20px" } }, xe = { class: "form-content" }, ze = { class: "attach-row" }, we = { key: 1, class: "flex-rcc", style: { padding: "20px 0" } }, Te = { key: 0 }, qe = { __name: "OAModal", props: { visible: { type: Boolean, default: false }, cover: { type: Boolean, default: false }, rowData: { type: Object, default: () => ({}) }, uploadType: { type: String, default: ".pdf" } }, emits: ["update:visible", "close", "success"], setup(r, { emit: $ }) {
  const p = r, T = $, { globalProject: K } = me(["globalProject"]), f = y(), E = y(false), b = y(null), v = y(_.TRUE.V), U = y(0), m = y({}), t = y({ title: "深化图纸文件盖章审批单", sqrq: "", sqr: "", sqrszbm: "", sqrszgs: "", xmmc: "", dtmc: "", yzlx: "", yyfs: "", cplx: "", szxz: void 0, jtjbr: "", fj: [], bz: "", attach: 0 }), k = [{ label: "生产用图专用章", value: 0 }], G = { title: [{ required: true, message: "请输入标题", trigger: "blur" }], xmmc: [{ required: true, message: "请输入项目名称", trigger: "blur" }], dtmc: [{ required: true, message: "请输入单体名称", trigger: "blur" }], szxz: [{ required: true, message: "请选择所属小组", trigger: "change" }], attach: [{ required: true, validator: (s, l, i) => {
    b.value ? i() : i(new Error("请上传附件"));
  }, trigger: "change" }] };
  function L(s) {
    v.value = s;
  }
  R(() => p.visible, (s) => {
    s && (v.value = _.TRUE.V, N(), b.value = null, q.value = 0, t.value.attach = 0, U.value++, f.value && f.value.clearValidate());
  }), R(() => v.value, (s) => {
    s === _.TRUE.V && N();
  });
  async function N() {
    try {
      const s = await ce();
      m.value = s || {};
    } catch {
      console.log("获取固定数据出错");
    }
    t.value = { title: "深化图纸文件盖章审批单", sqrq: fe(/* @__PURE__ */ new Date(), "{y}-{m}-{d}"), sqr: m.value.userName || "", sqrszbm: m.value.deptName || "", sqrszgs: m.value.sudDeptName || "", xmmc: ve(K.value), dtmc: p.rowData.monomerName || "", yzlx: [k[0].label], yyfs: 1, cplx: p.rowData.cplx, szxz: void 0, jtjbr: m.value.userName || "", fj: [], bz: "", attach: 0 }, f.value && f.value.clearValidate();
  }
  const q = y(0);
  async function Q(s) {
    const l = s.get("file");
    if (!l) throw new Error("未选择文件");
    return b.value && !await le.confirm("已选择 1 个附件，继续选择将覆盖之前的文件，是否继续？", "覆盖提示", { type: "warning" }).catch(() => false) ? false : (b.value = l, q.value = 1, t.value.attach = 1, f.value && f.value.validateField("attach"), S.success("附件已选择"), true);
  }
  function D(s) {
    return p.cover ? { projectId: s.projectId, monomerId: s.monomerId, productType: s.productType, dataType: s.dataType, cover: p.cover, productId: s.productId } : { projectId: s.projectId, monomerId: s.monomerId, productType: s.productType, dataType: s.dataType, cover: p.cover };
  }
  function H(s) {
    s && (T("success"), j());
  }
  async function J() {
    try {
      if (await f.value.validate()) {
        if (!b.value) {
          S.error("请上传附件");
          return;
        }
        E.value = true;
        try {
          const l = { ...t.value };
          delete l.fj;
          const i = { ...l, requestName: "深化图纸文件盖章审批流程（初鸣）", yzlx: Array.isArray(l.yzlx) ? l.yzlx.join(",") : l.yzlx };
          i.sqr = m.value.userId, i.jtjbr = m.value.userId, i.sqrszbm = m.value.deptId, i.sqrszgs = m.value.sudDeptId;
          const d = new FormData();
          d.append("multipartFile", b.value);
          const n = { ...D(p.rowData), fileName: b.value.name, oaParam: i };
          for (const u in n) if (u === "oaParam" && typeof n[u] == "object") for (const z in n[u]) d.append(`${z}`, n[u][z]);
          else d.append(u, n[u]);
          await _e(d), M({ title: "提交成功", type: "success", message: "OA审批流程已发起", duration: 2500 }), T("success"), j();
        } catch (l) {
          console.error(l), M({ title: "提交失败", type: "error", message: l.message || "OA审批流程发起失败", duration: 2500 });
        } finally {
          E.value = false;
        }
      }
    } catch (s) {
      console.error(s);
    }
  }
  function j() {
    T("update:visible", false), T("close");
  }
  return (s, l) => {
    const i = A("common-radio"), d = ae, n = te, u = oe, z = se, h = ue, B = ne, C = de, W = re, F = ie, X = A("common-dialog");
    return c(), V(X, { visible: r.visible, title: "文件导入", width: v.value === g(_).TRUE.V ? "680px" : "500px", "before-close": j, "close-on-click-modal": false }, { titleAfter: a(() => [w("div", Ve, [l[13] || (l[13] = w("div", { style: { "font-weight": "700", "font-size": "14px", width: "110px", "line-height": "32px" } }, [w("span", { style: { color: "#f56c6c", "font-weight": "normal", "margin-right": "4px" } }, "*"), x(" 是否走OA ")], -1)), e(i, { modelValue: v.value, "onUpdate:modelValue": l[0] || (l[0] = (o) => v.value = o), options: g(_).ENUM, type: "enum", onChange: L }, null, 8, ["modelValue", "options"])])]), footer: a(() => [v.value === g(_).TRUE.V ? (c(), I("div", Te, [e(F, { onClick: j }, { default: a(() => l[15] || (l[15] = [x("取消")])), _: 1, __: [15] }), e(F, { type: "primary", loading: E.value, onClick: J }, { default: a(() => l[16] || (l[16] = [x("提交")])), _: 1, __: [16] }, 8, ["loading"])])) : Y("", true)]), default: a(() => [v.value === g(_).TRUE.V ? (c(), V(W, { key: 0, ref_key: "formRef", ref: f, model: t.value, rules: G, "label-width": "100px", class: "oa-form" }, { default: a(() => [e(z, null, { default: a(() => [e(u, { span: 24, style: { "margin-bottom": "0" } }, { default: a(() => [e(n, { prop: "title", "label-width": "0" }, { default: a(() => [e(d, { modelValue: t.value.title, "onUpdate:modelValue": l[1] || (l[1] = (o) => t.value.title = o), class: "input-border-none header-center-title", placeholder: "请输入标题" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), w("div", xe, [e(z, { gutter: 20 }, { default: a(() => [e(u, { span: 12 }, { default: a(() => [e(n, { label: "申请日期", class: "el-form-item-5" }, { default: a(() => [e(d, { modelValue: t.value.sqrq, "onUpdate:modelValue": l[2] || (l[2] = (o) => t.value.sqrq = o), disabled: "", class: "input-underline" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(u, { span: 12 }, { default: a(() => [e(n, { label: "申请人" }, { default: a(() => [e(d, { modelValue: t.value.sqr, "onUpdate:modelValue": l[3] || (l[3] = (o) => t.value.sqr = o), disabled: "", class: "input-underline" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(u, { span: 12 }, { default: a(() => [e(n, { label: "所属部门" }, { default: a(() => [e(d, { modelValue: t.value.sqrszbm, "onUpdate:modelValue": l[4] || (l[4] = (o) => t.value.sqrszbm = o), disabled: "", class: "input-underline" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(u, { span: 12 }, { default: a(() => [e(n, { label: "所属公司" }, { default: a(() => [e(d, { modelValue: t.value.sqrszgs, "onUpdate:modelValue": l[5] || (l[5] = (o) => t.value.sqrszgs = o), disabled: "", class: "input-underline" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(u, { span: 12 }, { default: a(() => [e(n, { label: "项目名称", prop: "xmmc" }, { default: a(() => [e(d, { modelValue: t.value.xmmc, "onUpdate:modelValue": l[6] || (l[6] = (o) => t.value.xmmc = o), disabled: "", placeholder: "请输入项目名称", class: "input-underline" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(u, { span: 12 }, { default: a(() => [e(n, { label: "单体名称", prop: "dtmc" }, { default: a(() => [e(d, { modelValue: t.value.dtmc, "onUpdate:modelValue": l[7] || (l[7] = (o) => t.value.dtmc = o), maxlength: "100", placeholder: "请输入单体名称", class: "input-underline" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(u, { span: 12 }, { default: a(() => [e(n, { label: "用章类型", prop: "yzlx" }, { default: a(() => [e(B, { modelValue: t.value.yzlx, "onUpdate:modelValue": l[8] || (l[8] = (o) => t.value.yzlx = o), placeholder: "请选择", filterable: "", multiple: "", class: "input-underline", disabled: "", style: { width: "100%" } }, { default: a(() => [(c(), I(Z, null, ee(k, (o) => e(h, { key: o.value, label: o.label, value: o.label }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(u, { span: 12 }, { default: a(() => [e(n, { label: "用印份数", prop: "yyfs" }, { default: a(() => [e(d, { modelValue: t.value.yyfs, "onUpdate:modelValue": l[9] || (l[9] = (o) => t.value.yyfs = o), placeholder: "请输入份数", class: "input-underline" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(u, { span: 12 }, { default: a(() => [e(n, { label: "产品类型", prop: "cplx" }, { default: a(() => [x(O(t.value.cplx), 1)]), _: 1 })]), _: 1 }), e(u, { span: 12 }, { default: a(() => [e(n, { label: "所属小组", prop: "szxz" }, { default: a(() => [e(B, { modelValue: t.value.szxz, "onUpdate:modelValue": l[10] || (l[10] = (o) => t.value.szxz = o), placeholder: "请选择", filterable: "", class: "input-underline", style: { width: "100%" } }, { default: a(() => [e(h, { label: "一组", value: 0 }), e(h, { label: "二组", value: 1 }), e(h, { label: "三组", value: 2 })]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(u, { span: 12 }, { default: a(() => [e(n, { label: "具体经办人", prop: "jtjbr" }, { default: a(() => [e(d, { modelValue: t.value.jtjbr, "onUpdate:modelValue": l[11] || (l[11] = (o) => t.value.jtjbr = o), disabled: "", placeholder: "请输入经办人", class: "input-underline" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(u, { span: 24 }, { default: a(() => [e(n, { label: "附件", prop: "attach" }, { default: a(() => [(c(), V(P, { key: U.value, accept: `.zip,${r.uploadType}`, data: D(r.rowData), dataType: r.rowData.dataType, tip: r.uploadType, "upload-fun": Q, "success-msg": "附件已选择", size: "default", type: "primary" }, null, 8, ["accept", "data", "dataType", "tip"])), w("div", ze, [q.value > 0 ? (c(), V(C, { key: 0, type: "success", class: "attach-count" }, { default: a(() => [x("已选择 " + O(q.value) + " 个附件", 1)]), _: 1 })) : (c(), V(C, { key: 1, type: "info", class: "attach-count" }, { default: a(() => l[14] || (l[14] = [x("未选择附件")])), _: 1, __: [14] }))])]), _: 1 })]), _: 1 }), e(u, { span: 24 }, { default: a(() => [e(n, { label: "备注", prop: "bz" }, { default: a(() => [e(d, { type: "textarea", modelValue: t.value.bz, "onUpdate:modelValue": l[12] || (l[12] = (o) => t.value.bz = o), maxlength: "500", "show-word-limit": "", autosize: { minRows: 2 }, placeholder: "请输入备注", class: "textarea-container input-underline" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 })])]), _: 1 }, 8, ["model"])) : (c(), I("div", we, [(c(), V(P, { key: U.value, accept: `.zip,${r.uploadType}`, data: D(r.rowData), dataType: r.rowData.dataType, "success-msg": p.cover ? "覆盖导入成功" : "文件导入成功", tip: r.uploadType, "upload-fun": p.cover ? g(ye) : r.rowData.productType === 19 ? g(be) : g(ge), size: "default", type: "primary", onSuccess: H }, null, 8, ["accept", "data", "dataType", "success-msg", "tip", "upload-fun"]))]))]), _: 1 }, 8, ["visible", "width"]);
  };
} }, De = pe(qe, [["__scopeId", "data-v-fae03d38"]]);
export {
  De as default
};
