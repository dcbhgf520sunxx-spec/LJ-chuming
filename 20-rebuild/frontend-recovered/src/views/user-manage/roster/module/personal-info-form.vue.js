import { ref as c } from "vue";
import { computed as le } from "vue";
import We from "moment";
import { resolveComponent as U } from "vue";
import { openBlock as m } from "vue";
import { createBlock as x } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as i } from "vue";
import { withModifiers as He } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as Ge } from "vue";
import { unref as n } from "vue";
import { ElUpload as Ke } from "element-plus";
import { normalizeClass as Qe } from "vue";
import { createElementBlock as _ } from "vue";
import { Fragment as A } from "vue";
import { renderList as C } from "vue";
import { createCommentVNode as O } from "vue";
import { toDisplayString as ae } from "vue";
import { ElMessage as h } from "element-plus";
import { ElInput as Xe } from "element-plus";
import { ElFormItem as Je } from "element-plus";
import { ElCol as Ze } from "element-plus";
import { ElRow as et } from "element-plus";
import { ElDatePicker as tt } from "element-plus";
import { Plus as lt } from "@element-plus/icons-vue";
import { ElIcon as at } from "element-plus";
import { ElImage as nt } from "element-plus";
import { ZoomIn as ot } from "@element-plus/icons-vue";
import { Delete as st } from "@element-plus/icons-vue";
import { ElDialog as dt } from "element-plus";
import { ElPopover as rt } from "element-plus";
import { ElOption as it } from "element-plus";
import { ElSelect as ut } from "element-plus";
import { ElButton as pt } from "element-plus";
import { ElForm as mt } from "element-plus";
import { _ as ct, m as ft, X as gt, g8 as bt, n$ as E, u6 as I, ao as _t, n_ as S, S as q, bE as ht, iW as yt, v as ne, a as vt } from "../../../../shared/runtime.js";
import { e as Vt, f as xt, l as It, g as At } from "../../../../modules/roster-34ff8428.js";
import { r as Ct } from "../../../../modules/role-8519830b.js";
import { d as Et } from "../../../../modules/dept-398bb184.js";
import { j as wt } from "../../../../modules/job-fc547e81.js";
import kt from "./qr-code-dlg.vue.js";
import { m as Ut } from "../../../../modules/tree-select-86c0f12c.js";
import { _ as oe } from "../../../../modules/UploadBtn-b4cfb47a.js";
import "../../../../modules/index-c549a8fd.js";
import "../../../../modules/html2canvas.esm-e0a7d97b.js";
const Dt = { class: "profile-photo" }, Nt = { class: "el-upload-list__item-actions" }, Tt = ["onClick"], Mt = ["onClick"], Rt = ["src"], jt = { class: "form-grop" }, zt = { class: "form-grop" }, Yt = { class: "form-grop" }, Ot = { key: 0 }, St = { class: "upload-list" }, qt = { class: "upload-item" }, Bt = { key: 0, class: "file-list" }, Lt = { style: { "margin-left": "6px" } }, Pt = ["href"], $t = { style: { "font-size": "14px", color: "#409eff !important" } }, Ft = { class: "upload-item" }, Wt = { key: 0, class: "file-list" }, Ht = { style: { "margin-left": "6px" } }, Gt = ["href"], Kt = { style: { "font-size": "14px", color: "#409eff !important" } }, Qt = { __name: "personal-info-form", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, nationList: { type: Array, default: () => [] } }, emits: ["update:visible", "success"], setup(Xt, { emit: se }) {
  const de = se, { fileUploadApi: re } = ft("fileUploadApi"), ie = c({ Authorization: gt() }), B = bt(["work_type", "cert_type"]), D = c(false), N = c(), T = c(false), L = c(""), y = c(false), P = c([]), M = c([]), $ = c([]), ue = c(false), R = c(false), F = c(), pe = le(() => {
    var s;
    return ((s = e.avatarAttachment) == null ? void 0 : s.length) > 0;
  }), me = c({ name: void 0, idNumber: void 0, sex: void 0, birthDate: void 0, nation: void 0, homeAddress: void 0, avatarAttachmentId: void 0, employeeCategory: E.OWN_EMPLOYEE.V, supplierId: void 0, entryDate: We().valueOf(), workType: void 0, boolCert: I.NO.V, deptId: void 0, deptName: void 0, jobId: void 0, roleIds: void 0, avatarAttachment: [], certAttachments: [], physicalExaminationAttachment: [], certs: [{ certType: void 0, expirationTime: void 0 }], physicalExaminationAttachmentIds: void 0, certAttachmentIds: void 0 }), { crud: w, CRUD: W, form: e } = _t(me, N);
  W.HOOK.beforeToAdd = () => {
    setTimeout(() => {
      F.value.focus();
    }, 500);
  }, W.HOOK.beforeToEdit = () => {
    H(e.phone), e.avatarAttachment ? e.avatarAttachment = [e.avatarAttachment] : e.avatarAttachment = [], e.sex = S.VL[e.sex], e.birthDate = ce(e.birthDate);
  };
  function ce(s) {
    let l = new Date(s), u = l.getFullYear(), b = l.getMonth() + 1, p = l.getDate();
    return `${u}-${String(b).padStart(2, "0")}-${String(p).padStart(2, "0")}`;
  }
  const v = le(() => w.status.edit > 0), fe = (s, l, u) => {
    e.employeeCategory === E.EXPATRIATES.V && !l && u(new Error("请选择雇主单位")), u();
  };
  function ge(s) {
    /^[男女]$/.test(s) || (e.sex = void 0, h.error("请输入男或女！"));
  }
  const be = { name: [{ required: true, message: "请输入名称", trigger: "blur" }], idNumber: [{ required: true, message: "请输入身份证号", trigger: "blur" }], sex: [{ required: true, message: "请输入性别", trigger: "blur" }], birthDate: [{ required: true, message: "请选择出生日期", trigger: "change" }], nation: [{ required: true, message: "请输入民族", trigger: "blur" }], homeAddress: [{ required: true, message: "请输入家庭住址", trigger: "blur" }], employeeCategory: [{ required: true, message: "请选择员工类别", trigger: "change" }], entryDate: [{ required: true, message: "请选择入职日期", trigger: "change" }], boolCert: [{ required: true, message: "请选择是否有证书", trigger: "change" }], expirationTime: [{ required: true, message: "请选择到期时间", trigger: "change" }], supplierId: [{ validator: fe, message: "请选择雇主单位", trigger: "change" }], workType: [{ required: true, message: "请选择公种", trigger: "change" }], phone: [{ required: true, message: "请填写手机号", trigger: "blur" }, { pattern: ne, message: "请填写正确的手机号", trigger: "blur" }], username: [{ required: true, message: "请填写员工编号", trigger: "blur" }] };
  async function H(s) {
    try {
      const { username: l, dept: u, deptId: b, job: p, roles: d, id: r } = await Vt({ phone: s });
      e.username = l || void 0, e.deptName = (u == null ? void 0 : u.name) || void 0, e.deptId = b || void 0, e.jobId = (p == null ? void 0 : p.id) || void 0, e.userId = r || void 0, (d == null ? void 0 : d.length) > 0 && (e.roleIds = d.map((f) => f.id) || []), y.value = true;
    } catch (l) {
      e.username = void 0, e.deptName = void 0, e.deptId = void 0, e.jobId = void 0, e.userId = void 0, e.roleIds = [], y.value = false, console.log(l);
    }
  }
  function _e(s) {
    s === I.NO.V ? e.certs = [] : e.certs = [{ certType: void 0, expirationTime: void 0 }];
  }
  function he(s) {
    ne.test(s) ? H(s) : (e.username = void 0, e.deptName = void 0, e.deptId = void 0, e.jobId = void 0, e.roleIds = [], y.value = false, h.error("请填写正确的手机号！"));
  }
  async function ye(s) {
    try {
      const l = await At(s);
      e.avatarAttachment = [l];
    } catch (l) {
      console.log(l);
    }
  }
  function ve(s, l, u) {
    u.splice(u.length - 1, 1), s.code === 2e4 ? (s.data.id && ye(s.data.id), e.avatarAttachmentId = s.data.id, h.success("上传成功")) : h.error(s.message);
  }
  function Ve() {
  }
  function xe(s, l) {
    s.certAttachments.splice(l, 1);
  }
  function Ie() {
  }
  function Ae(s, l) {
    s.physicalExaminationAttachment.splice(l, 1);
  }
  function Ce(s, l, u) {
    h.error(s.message);
  }
  function Ee() {
    h.error("最多只能上传1张头像");
  }
  function G(s) {
    return s > /* @__PURE__ */ new Date();
  }
  function we(s) {
    return s.size > 10 * 1024 * 1024 ? (h.error("上传logo大小不能超过10MB!", 2e3), false) : true;
  }
  function ke(s) {
    L.value = s.imageUrl, T.value = true;
  }
  async function Ue(s) {
    try {
      e.avatarAttachment = [], e.avatarAttachmentId = void 0;
    } catch (l) {
      console.log("删除失败", l);
    }
  }
  De();
  async function De() {
    try {
      P.value = await Et({ hasRoot: true });
    } catch (s) {
      console.log("部门tree", s);
    }
  }
  Ne();
  async function Ne() {
    try {
      const { content: s } = await Ct();
      $.value = s;
    } catch (s) {
      console.log("获取角色", s);
    }
  }
  function Te(s) {
    e.deptId = s.id, e.deptName = s.name, K(s.id), R.value = false;
  }
  K();
  async function K(s) {
    M.value = [];
    try {
      const l = { deptId: s }, { content: u } = await wt(l);
      u.findIndex((p) => p.id === e.jobId) === -1 && (e.jobId = void 0), M.value = u;
    } catch (l) {
      console.log("获取角色", l);
    }
  }
  async function Me() {
    var l, u;
    D.value = true;
    const s = { 男: "0", 女: "1" };
    e.sex = s[e.sex] || e.sex;
    try {
      if (!await N.value.validate()) return false;
      if (e.boolCert === I.NO.V && (e.certs = []), e.userSaveRequestVO = { username: e.username, deptName: e.deptName, deptId: e.deptId, jobId: e.jobId, userId: e.userId, roleIds: e.roleIds || void 0, phone: e.phone }, ((l = e.certAttachments) == null ? void 0 : l.length) > 0) {
        const p = e.certAttachments.map((d) => d.id);
        e.certAttachmentIds = p.join();
      } else e.certAttachmentIds = void 0;
      if (((u = e.physicalExaminationAttachment) == null ? void 0 : u.length) > 0) {
        const p = e.physicalExaminationAttachment.map((d) => d.id);
        e.physicalExaminationAttachmentIds = p.join();
      } else e.physicalExaminationAttachmentIds = void 0;
      if (e.boolCert === I.YES.V && !e.certAttachmentIds) return h.error("请上传证书！"), e.sex = S.VL[e.sex] || e.sex, false;
      v.value ? await xt(e) : await It(e), w.cancelCU(), h.success("录入成功！"), de("success");
    } catch (b) {
      console.log(b);
    } finally {
      e.sex = S.VL[e.sex] || e.sex, D.value = false;
    }
  }
  function Re(s) {
    s === E.OWN_EMPLOYEE.V && (e.supplierId = void 0);
  }
  function je() {
    e.certs.push({ certType: void 0, expirationTime: void 0 });
  }
  function ze(s) {
    e.certs.splice(s, 1);
  }
  const j = c(false);
  function Ye() {
    j.value = true;
  }
  return (s, l) => {
    const u = vt, b = U("common-button"), p = Xe, d = Je, r = Ze, f = et, z = tt, Oe = lt, Y = at, Se = nt, qe = ot, Be = st, Le = dt, Q = U("common-radio"), X = U("common-select"), Pe = rt, J = it, Z = ut, ee = pt, $e = mt, Fe = U("common-drawer");
    return m(), x(Fe, { "append-to-body": "", title: "人员信息录入", visible: n(w).status.cu > 0, "before-close": n(w).cancelCU, "close-on-click-modal": false, size: "42%" }, { titleAfter: o(() => [i("span", { class: "pointer", onClick: He(Ye, ["stop"]) }, [t(u, { style: { "font-size": "25px" }, "icon-class": "qr-code" })])]), titleRight: o(() => [t(b, { loading: D.value, type: "success", size: "default", onClick: Me }, { default: o(() => l[23] || (l[23] = [Ge("确认")])), _: 1, __: [23] }, 8, ["loading"])]), content: o(() => [t($e, { ref_key: "formRef", ref: N, model: n(e), rules: be }, { default: o(() => {
      var k, te;
      return [t(f, { class: "form-grop" }, { default: o(() => [t(r, { span: 20 }, { default: o(() => [t(f, null, { default: o(() => [t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "姓名", prop: "name" }, { default: o(() => [t(p, { ref_key: "focusInputRef", ref: F, modelValue: n(e).name, "onUpdate:modelValue": l[0] || (l[0] = (a) => n(e).name = a), placeholder: "请输入姓名", maxlength: "64", style: { width: "100%", height: "100%" }, size: "default", class: "input-border-none", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "身份证号", prop: "idNumber" }, { default: o(() => [t(p, { modelValue: n(e).idNumber, "onUpdate:modelValue": l[1] || (l[1] = (a) => n(e).idNumber = a), placeholder: "请输入身份证号", style: { width: "100%", height: "100%" }, size: "default", class: "input-border-none", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), t(f, null, { default: o(() => [t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "性别", prop: "sex" }, { default: o(() => [t(p, { modelValue: n(e).sex, "onUpdate:modelValue": l[2] || (l[2] = (a) => n(e).sex = a), onBlur: l[3] || (l[3] = (a) => ge(n(e).sex)), placeholder: "请输入性别", style: { width: "100%", height: "100%" }, size: "default", clearable: "", class: "input-border-none" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item birthDate", label: "出生日期", prop: "birthDate" }, { default: o(() => [t(z, { modelValue: n(e).birthDate, "onUpdate:modelValue": l[4] || (l[4] = (a) => n(e).birthDate = a), class: "input-border-none", "disabled-date": G, type: "date", format: "YYYY-MM-DD", "value-format": "YYYY-MM-DD", placeholder: "请选择日期" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), t(f, null, { default: o(() => [t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "民族", prop: "nation" }, { default: o(() => [t(p, { modelValue: n(e).nation, "onUpdate:modelValue": l[5] || (l[5] = (a) => n(e).nation = a), placeholder: "请输入民族", style: { width: "100%", height: "100%" }, size: "default", class: "input-border-none", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "家庭住址", prop: "homeAddress" }, { default: o(() => [t(p, { modelValue: n(e).homeAddress, "onUpdate:modelValue": l[6] || (l[6] = (a) => n(e).homeAddress = a), placeholder: "请输入家庭住址", style: { width: "100%", height: "100%" }, maxlength: "100", size: "default", clearable: "", class: "input-border-none" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }), t(r, { span: 4 }, { default: o(() => [i("div", Dt, [t(n(Ke), { action: n(re), accept: "image/*", limit: 1, headers: ie.value, "list-type": "picture-card", style: { display: "flex", width: "100%", height: "100%" }, data: { fileType: n(q).NORMAL.V }, class: Qe({ disabled: pe.value }), "file-list": n(e).avatarAttachment, "before-upload": we, "on-success": ve, "on-error": Ce, "on-exceed": Ee }, { file: o(({ file: a }) => [t(Se, { class: "el-upload-list__item-thumbnail", src: a.imageUrl, alt: "logo", fit: "scale-down" }, null, 8, ["src"]), i("span", Nt, [i("span", { class: "el-upload-list__item-preview", onClick: (g) => ke(a) }, [t(Y, null, { default: o(() => [t(qe)]), _: 1 })], 8, Tt), i("span", { class: "el-upload-list__item-delete", onClick: (g) => Ue(a) }, [t(Y, null, { default: o(() => [t(Be)]), _: 1 })], 8, Mt)])]), default: o(() => [t(Y, null, { default: o(() => [t(Oe)]), _: 1 })]), _: 1 }, 8, ["action", "headers", "data", "class", "file-list"]), t(Le, { modelValue: T.value, "onUpdate:modelValue": l[7] || (l[7] = (a) => T.value = a) }, { default: o(() => [i("img", { style: { width: "100%" }, src: L.value, alt: "" }, null, 8, Rt)]), _: 1 }, 8, ["modelValue"])])]), _: 1 })]), _: 1 }), i("div", jt, [t(f, null, { default: o(() => [t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "员工类别", prop: "employeeCategory" }, { default: o(() => [t(Q, { modelValue: n(e).employeeCategory, "onUpdate:modelValue": l[8] || (l[8] = (a) => n(e).employeeCategory = a), options: n(E).ENUM, type: "enum", onChange: Re }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }), t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "雇主单位", prop: "supplierId" }, { default: o(() => [t(ht, { modelValue: n(e).supplierId, "onUpdate:modelValue": l[9] || (l[9] = (a) => n(e).supplierId = a), basicClass: n(yt).LABOR_SUBCONTRACTING.V, disabled: n(e).employeeCategory === n(E).OWN_EMPLOYEE.V, showType: false, clearable: "", class: "input-border-none", placeholder: "请选择雇主单位", style: { width: "100%", height: "100%" } }, null, 8, ["modelValue", "basicClass", "disabled"])]), _: 1 })]), _: 1 })]), _: 1 }), t(f, null, { default: o(() => [t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "入职日期", prop: "entryDate" }, { default: o(() => [t(z, { modelValue: n(e).entryDate, "onUpdate:modelValue": l[10] || (l[10] = (a) => n(e).entryDate = a), "disabled-date": G, type: "date", format: "YYYY-MM-DD", "value-format": "x", class: "input-border-none", placeholder: "请选择日期" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "工种", prop: "workType" }, { default: o(() => [t(X, { modelValue: n(e).workType, "onUpdate:modelValue": l[11] || (l[11] = (a) => n(e).workType = a), options: n(B).work_type, clearable: "", filterable: "", type: "dict", size: "default", class: "input-border-none", placeholder: "请选择工种", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 })]), _: 1 })]), i("div", zt, [t(f, null, { default: o(() => [t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "手机号", prop: "phone" }, { default: o(() => [t(p, { modelValue: n(e).phone, "onUpdate:modelValue": l[12] || (l[12] = (a) => n(e).phone = a), placeholder: "请输入手机号", style: { width: "100%", height: "100%" }, size: "default", clearable: "", class: "input-border-none", disabled: v.value, onBlur: l[13] || (l[13] = (a) => he(n(e).phone)) }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }), t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "员工编号", prop: "username" }, { default: o(() => [t(p, { modelValue: n(e).username, "onUpdate:modelValue": l[14] || (l[14] = (a) => n(e).username = a), placeholder: "请输入员工编号", style: { width: "100%", height: "100%" }, disabled: y.value || v.value, size: "default", class: "input-border-none", clearable: "" }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 })]), _: 1 }), t(f, null, { default: o(() => [t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "部门", prop: "dept" }, { default: o(() => [t(Pe, { placement: "bottom-start", width: "460", trigger: "click", visible: R.value, "onUpdate:visible": l[16] || (l[16] = (a) => R.value = a), ref: "menuPopover" }, { reference: o(() => [t(p, { modelValue: n(e).deptName, "onUpdate:modelValue": l[15] || (l[15] = (a) => n(e).deptName = a), disabled: y.value || v.value, clearable: "", placeholder: "点击选择所属部门", readonly: "", class: "input-border-none" }, null, 8, ["modelValue", "disabled"])]), default: o(() => [t(Ut, { ref: "menuSelectRef", onSelected: Te, style: { width: "400px" }, pid: n(e).deptId, treeMenu: P.value, class: "input-border-none", defaultProps: { children: "children", label: "name" } }, null, 8, ["pid", "treeMenu"])]), _: 1 }, 8, ["visible"])]), _: 1 })]), _: 1 }), t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "岗位", prop: "jobId" }, { default: o(() => [t(Z, { modelValue: n(e).jobId, "onUpdate:modelValue": l[17] || (l[17] = (a) => n(e).jobId = a), disabled: y.value || v.value, clearable: "", placeholder: "请先选择部门", class: "input-border-none" }, { default: o(() => [(m(true), _(A, null, C(M.value, (a) => (m(), x(J, { key: a.id, label: a.name, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 })]), _: 1 }), t(f, null, { default: o(() => [t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "角色", prop: "roles" }, { default: o(() => [t(Z, { modelValue: n(e).roleIds, "onUpdate:modelValue": l[18] || (l[18] = (a) => n(e).roleIds = a), multiple: "", disabled: y.value || v.value, clearable: "", class: "input-border-none", placeholder: "请选择", loading: ue.value }, { default: o(() => [(m(true), _(A, null, C($.value, (a, g) => (m(), x(J, { key: `${g}`, label: a.name, value: a.id, disabled: a.id === 1 }, null, 8, ["label", "value", "disabled"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled", "loading"])]), _: 1 })]), _: 1 }), t(r, { span: 12 }, { default: o(() => l[24] || (l[24] = [i("div", { style: { height: "100%", border: "1px solid #dcdfe6", "border-bottom": "0", "border-right": "0" } }, null, -1)])), _: 1, __: [24] })]), _: 1 })]), i("div", Yt, [t(f, null, { default: o(() => [t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", style: { "border-right": "1px solid #dcdfe6" }, label: "证书", prop: "boolCert" }, { default: o(() => [t(Q, { modelValue: n(e).boolCert, "onUpdate:modelValue": l[19] || (l[19] = (a) => n(e).boolCert = a), options: n(I).ENUM, type: "enum", onChange: _e }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 })]), _: 1 }), n(e).boolCert === n(I).YES.V ? (m(), _("div", Ot, [(m(true), _(A, null, C(n(e).certs, (a, g) => (m(), x(f, { key: g }, { default: o(() => [t(r, { span: 12 }, { default: o(() => [t(d, { class: "form-item", label: "证书类型", prop: "certs." + g + ".certType", rules: { required: true, message: "请选择证书类型", trigger: "change" } }, { default: o(() => [t(X, { modelValue: a.certType, "onUpdate:modelValue": (V) => a.certType = V, options: n(B).cert_type, clearable: "", filterable: "", type: "dict", size: "default", class: "input-border-none", placeholder: "请选择证书类型" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"])]), _: 2 }, 1024), t(r, { span: 12, style: { display: "flex", "align-items": "center" } }, { default: o(() => [t(d, { class: "form-item", label: "到期时间", prop: "certs." + g + ".expirationTime", rules: { required: true, message: "请选择到期时间", trigger: "change" }, style: { flex: "1" } }, { default: o(() => [t(z, { class: "input-border-none", modelValue: a.expirationTime, "onUpdate:modelValue": (V) => a.expirationTime = V, type: "date", format: "YYYY-MM-DD", "value-format": "x", placeholder: "请选择日期" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), g === 0 ? (m(), x(b, { key: 0, size: "default", type: "success", icon: "el-icon-plus", style: { "margin-left": "4px" }, onClick: je })) : (m(), x(b, { key: 1, size: "default", type: "danger", icon: "el-icon-delete", style: { "margin-left": "4px" }, onClick: (V) => ze(g) }, null, 8, ["onClick"]))]), _: 2 }, 1024)]), _: 2 }, 1024))), 128))])) : O("", true)]), l[27] || (l[27] = i("div", { class: "format-tips" }, "*证书文件导入支持pdf格式、jpg格式、jpeg格式、png格式", -1)), i("div", St, [i("div", qt, [l[25] || (l[25] = i("span", null, "证书：", -1)), t(n(oe), { ref: "uploadRef", files: n(e).certAttachments, "onUpdate:files": l[20] || (l[20] = (a) => n(e).certAttachments = a), "file-classify": n(q).NORMAL.V, "show-file-list": false, btnName: "导入", btnType: "primary", accept: ".pdf,.jpg,.jpeg,.png", onChange: Ve }, null, 8, ["files", "file-classify"]), (k = n(e).certAttachments) != null && k.length ? (m(), _("div", Bt, [(m(true), _(A, null, C(n(e).certAttachments, (a, g) => (m(), _("div", { key: a.id, style: { width: "100%", "margin-bottom": "10px" } }, [i("div", Lt, [i("a", { href: a == null ? void 0 : a.imageUrl, target: "_blank", class: "ellipsis-text", style: { display: "inline-block", width: "160px" } }, [i("span", $t, ae(a == null ? void 0 : a.name), 1)], 8, Pt), t(ee, { size: "default", icon: "el-icon-delete", type: "danger", style: { "margin-left": "10px" }, onClick: (V) => xe(n(e), g) }, null, 8, ["onClick"])])]))), 128))])) : O("", true)]), i("div", Ft, [l[26] || (l[26] = i("span", null, "体检报告：", -1)), t(n(oe), { ref: "uploadRef", files: n(e).physicalExaminationAttachment, "onUpdate:files": l[21] || (l[21] = (a) => n(e).physicalExaminationAttachment = a), "file-classify": n(q).NORMAL.V, "show-file-list": false, btnName: "导入", btnType: "primary", accept: ".pdf,.jpg,.jpeg,.png", onChange: Ie }, null, 8, ["files", "file-classify"]), (te = n(e).physicalExaminationAttachment) != null && te.length ? (m(), _("div", Wt, [(m(true), _(A, null, C(n(e).physicalExaminationAttachment, (a, g) => (m(), _("div", { key: a.id, style: { width: "100%", "margin-bottom": "10px" } }, [i("div", Ht, [i("a", { href: a == null ? void 0 : a.imageUrl, target: "_blank", class: "ellipsis-text", style: { display: "inline-block", width: "160px" } }, [i("span", Kt, ae(a == null ? void 0 : a.name), 1)], 8, Gt), t(ee, { size: "default", icon: "el-icon-delete", type: "danger", style: { "margin-left": "10px" }, onClick: (V) => Ae(n(e), g) }, null, 8, ["onClick"])])]))), 128))])) : O("", true)])])];
    }), _: 1, __: [27] }, 8, ["model"]), t(n(kt), { visible: j.value, "onUpdate:visible": l[22] || (l[22] = (k) => j.value = k), data: n(e) }, null, 8, ["visible", "data"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, ul = ct(Qt, [["__scopeId", "data-v-f66a447a"]]);
export {
  ul as default
};
