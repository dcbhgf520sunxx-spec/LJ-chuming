import { ref as h } from "vue";
import { computed as L } from "vue";
import Re from "moment";
import { resolveComponent as V } from "vue";
import { openBlock as p } from "vue";
import { createBlock as x } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as i } from "vue";
import { withModifiers as Ye } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as qe } from "vue";
import { unref as n } from "vue";
import { ElUpload as Se } from "element-plus";
import { normalizeClass as Be } from "vue";
import { createElementBlock as g } from "vue";
import { Fragment as M } from "vue";
import { renderList as R } from "vue";
import { createCommentVNode as Y } from "vue";
import { toDisplayString as H } from "vue";
import { ElMessage as b } from "element-plus";
import { ElInput as Oe } from "element-plus";
import { ElFormItem as $e } from "element-plus";
import { ElCol as Fe } from "element-plus";
import { ElRow as Pe } from "element-plus";
import { ElDatePicker as Le } from "element-plus";
import { Plus as He } from "@element-plus/icons-vue";
import { ElIcon as Ge } from "element-plus";
import { ElImage as Je } from "element-plus";
import { ZoomIn as Ke } from "@element-plus/icons-vue";
import { Delete as Qe } from "@element-plus/icons-vue";
import { ElDialog as Xe } from "element-plus";
import { ElButton as Ze } from "element-plus";
import { ElForm as We } from "element-plus";
import { _ as et, m as tt, X as at, g8 as lt, u6 as v, ao as nt, u7 as ot, S as q, v as G, a as st } from "../../../../../shared/runtime.js";
import { e as it, l as rt, f as dt, h as ut } from "../../../../../modules/roster-manage-12e649bc.js";
import { r as ct } from "../../../../../modules/role-8519830b.js";
import { d as mt } from "../../../../../modules/dept-398bb184.js";
import { j as pt } from "../../../../../modules/job-fc547e81.js";
import ft from "./qr-code-dlg.vue.js";
import { _ as J } from "../../../../../modules/UploadBtn-b4cfb47a.js";
import { _ as ht } from "../../../../../modules/subcontract-supplier-select-bab9e7f8.js";
import "../../../../../modules/index-c549a8fd.js";
import "../../../../../modules/html2canvas.esm-e0a7d97b.js";
const _t = { class: "profile-photo" }, gt = { class: "el-upload-list__item-actions" }, bt = ["onClick"], yt = ["onClick"], vt = ["src"], It = { class: "form-grop" }, At = { class: "form-grop" }, Vt = { key: 0 }, xt = { class: "upload-list" }, wt = { class: "upload-item" }, Ct = { key: 0, class: "file-list" }, kt = { style: { "margin-left": "6px" } }, Et = ["href"], Dt = { style: { "font-size": "14px", color: "#409eff !important" } }, Ut = { class: "upload-item" }, Nt = { key: 0, class: "file-list" }, Tt = { style: { "margin-left": "6px" } }, jt = ["href"], zt = { style: { "font-size": "14px", color: "#409eff !important" } }, Mt = { __name: "personal-info-form", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, nationList: { type: Array, default: () => [] }, projectId: { type: Number, default: void 0 } }, emits: ["update:visible", "success"], setup(K, { emit: Q }) {
  const X = Q, { fileUploadApi: Z } = tt("fileUploadApi"), W = h({ Authorization: at() }), S = lt(["site_work_type", "site_cert_type"]), w = K, C = h(false), k = h(), E = h(false), B = h(""), D = h(false), ee = h([]), O = h([]), te = h([]), ae = L(() => {
    var s;
    return ((s = e.avatarAttachment) == null ? void 0 : s.length) > 0;
  }), le = h({ name: void 0, idNumber: void 0, sex: void 0, birthDate: void 0, nation: void 0, homeAddress: void 0, avatarAttachmentId: void 0, supplierId: void 0, entryDate: Re().valueOf(), workType: void 0, boolCert: v.NO.V, deptId: void 0, deptName: void 0, jobId: void 0, roleIds: void 0, avatarAttachment: [], certAttachments: [], physicalExaminationAttachment: [], certs: [{ certType: void 0, expirationTime: void 0 }], physicalExaminationAttachmentIds: void 0, certAttachmentIds: void 0 }), { crud: I, CRUD: ne, form: e } = nt(le, k);
  ne.HOOK.beforeToEdit = () => {
    e.avatarAttachment ? e.avatarAttachment = [e.avatarAttachment] : e.avatarAttachment = [], e.birthDate = oe(e.birthDate);
  };
  function oe(s) {
    let t = new Date(s), d = t.getFullYear(), m = t.getMonth() + 1, u = t.getDate();
    return `${d}-${String(m).padStart(2, "0")}-${String(u).padStart(2, "0")}`;
  }
  const U = L(() => I.status.edit > 0), se = { name: [{ required: true, message: "请输入名称", trigger: "blur" }], idNumber: [{ required: true, message: "请输入身份证号", trigger: "blur" }], sex: [{ required: true, message: "请选择性别", trigger: "blur" }], birthDate: [{ required: true, message: "请选择出生日期", trigger: "change" }], nation: [{ required: true, message: "请输入民族", trigger: "blur" }], homeAddress: [{ required: true, message: "请输入家庭住址", trigger: "blur" }], entryDate: [{ required: true, message: "请选择入职日期", trigger: "change" }], boolCert: [{ required: true, message: "请选择是否有证书", trigger: "change" }], expirationTime: [{ required: true, message: "请选择到期时间", trigger: "change" }], supplierId: [{ required: true, message: "请选择雇主单位", trigger: "change" }], workType: [{ required: true, message: "请选择工种", trigger: "change" }], phone: [{ required: true, message: "请填写手机号", trigger: "blur" }, { pattern: G, message: "请填写正确的手机号", trigger: "blur" }] };
  async function $(s) {
    try {
      const { username: t, dept: d, deptId: m, job: u, roles: r, id: c } = await dt({ phone: s });
      e.username = t || void 0, e.deptName = (d == null ? void 0 : d.name) || void 0, e.deptId = m || void 0, e.jobId = (u == null ? void 0 : u.id) || void 0, e.userId = c || void 0, (r == null ? void 0 : r.length) > 0 && (e.roleIds = r.map((_) => _.id) || []), D.value = true;
    } catch (t) {
      e.username = void 0, e.deptName = void 0, e.deptId = void 0, e.jobId = void 0, e.userId = void 0, e.roleIds = [], D.value = false, console.log(t);
    }
  }
  function ie(s) {
    s === v.NO.V ? e.certs = [] : e.certs = [{ certType: void 0, expirationTime: void 0 }];
  }
  function re(s) {
    U.value || (G.test(s) ? $(s) : (e.username = void 0, e.deptName = void 0, e.deptId = void 0, e.jobId = void 0, e.roleIds = [], D.value = false, b.error("请填写正确的手机号！")));
  }
  async function de(s) {
    try {
      const t = await ut(s);
      e.avatarAttachment = [t];
    } catch (t) {
      console.log(t);
    }
  }
  function ue(s, t, d) {
    d.splice(d.length - 1, 1), s.code === 2e4 ? (s.data.id && de(s.data.id), e.avatarAttachmentId = s.data.id, b.success("上传成功")) : b.error(s.message);
  }
  function ce() {
  }
  function me(s, t) {
    s.certAttachments.splice(t, 1);
  }
  function pe() {
  }
  function fe(s, t) {
    s.physicalExaminationAttachment.splice(t, 1);
  }
  function he(s, t, d) {
    b.error(s.message);
  }
  function _e() {
    b.error("最多只能上传1张头像");
  }
  function ge(s) {
    return s > /* @__PURE__ */ new Date();
  }
  function be(s) {
    return s.size > 10 * 1024 * 1024 ? (b.error("上传logo大小不能超过10MB!", 2e3), false) : true;
  }
  function ye(s) {
    B.value = s.imageUrl, E.value = true;
  }
  async function ve(s) {
    try {
      e.avatarAttachment = [], e.avatarAttachmentId = void 0;
    } catch (t) {
      console.log("删除失败", t);
    }
  }
  Ie();
  async function Ie() {
    try {
      ee.value = await mt({ hasRoot: true });
    } catch (s) {
      console.log("部门tree", s);
    }
  }
  Ae();
  async function Ae() {
    try {
      const { content: s } = await ct();
      te.value = s;
    } catch (s) {
      console.log("获取角色", s);
    }
  }
  Ve();
  async function Ve(s) {
    O.value = [];
    try {
      const t = { deptId: s }, { content: d } = await pt(t);
      d.findIndex((u) => u.id === e.jobId) === -1 && (e.jobId = void 0), O.value = d;
    } catch (t) {
      console.log("获取角色", t);
    }
  }
  async function xe() {
    var s, t;
    C.value = true;
    try {
      if (!await k.value.validate()) return false;
      if (e.boolCert === v.NO.V && (e.certs = []), U.value ? (e.userSaveRequestVO = { username: e.username, deptName: e.deptName, deptId: e.deptId, jobId: e.jobId, userId: e.userId, roleIds: e.roleIds || void 0, phone: e.phone }, console.log(e, w.currentRow, "currentRow")) : (await $(e.phone), e.userSaveRequestVO = { username: e.username, deptName: e.deptName, deptId: e.deptId, jobId: e.jobId, userId: e.userId, roleIds: e.roleIds || void 0, phone: e.phone }), ((s = e.certAttachments) == null ? void 0 : s.length) > 0) {
        const m = e.certAttachments.map((u) => u.id);
        e.certAttachmentIds = m.join();
      } else e.certAttachmentIds = void 0;
      if (((t = e.physicalExaminationAttachment) == null ? void 0 : t.length) > 0) {
        const m = e.physicalExaminationAttachment.map((u) => u.id);
        e.physicalExaminationAttachmentIds = m.join();
      } else e.physicalExaminationAttachmentIds = void 0;
      if (e.boolCert === v.YES.V && !e.certAttachmentIds) return b.error("请上传证书！"), false;
      e.projectId = w.projectId, U.value ? await it(e) : await rt(e), I.cancelCU(), b.success("录入成功！"), X("success");
    } catch (d) {
      console.log(d);
    } finally {
      C.value = false;
    }
  }
  function we() {
    e.certs.push({ certType: void 0, expirationTime: void 0 });
  }
  function Ce(s) {
    e.certs.splice(s, 1);
  }
  const N = h(false);
  function ke() {
    N.value = true;
  }
  return (s, t) => {
    const d = st, m = V("common-button"), u = Oe, r = $e, c = Fe, _ = Pe, T = V("common-select"), j = Le, Ee = He, z = Ge, De = Je, Ue = Ke, Ne = Qe, Te = Xe, je = V("common-radio"), F = Ze, ze = We, Me = V("common-drawer");
    return p(), x(Me, { "append-to-body": "", title: "人员信息录入", visible: n(I).status.cu > 0, "before-close": n(I).cancelCU, "close-on-click-modal": false, size: "42%" }, { titleAfter: o(() => [i("span", { class: "pointer", onClick: Ye(ke, ["stop"]) }, [a(d, { style: { "font-size": "25px" }, "icon-class": "qr-code" })])]), titleRight: o(() => [a(m, { loading: C.value, type: "success", size: "default", onClick: xe }, { default: o(() => t[16] || (t[16] = [qe("确认")])), _: 1, __: [16] }, 8, ["loading"])]), content: o(() => [a(ze, { ref_key: "formRef", ref: k, model: n(e), rules: se }, { default: o(() => {
      var A, P;
      return [a(_, { class: "form-grop" }, { default: o(() => [a(c, { span: 20 }, { default: o(() => [a(_, null, { default: o(() => [a(c, { span: 12 }, { default: o(() => [a(r, { class: "form-item", label: "姓名", prop: "name" }, { default: o(() => [a(u, { modelValue: n(e).name, "onUpdate:modelValue": t[0] || (t[0] = (l) => n(e).name = l), placeholder: "请输入姓名", maxlength: "64", class: "input-border-none", style: { width: "100%", height: "100%" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), a(c, { span: 12 }, { default: o(() => [a(r, { class: "form-item", label: "身份证号", prop: "idNumber" }, { default: o(() => [a(u, { modelValue: n(e).idNumber, "onUpdate:modelValue": t[1] || (t[1] = (l) => n(e).idNumber = l), class: "input-border-none", placeholder: "请输入身份证号", style: { width: "100%", height: "100%" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), a(_, null, { default: o(() => [a(c, { span: 12 }, { default: o(() => [a(r, { class: "form-item", label: "性别", prop: "sex" }, { default: o(() => [a(T, { modelValue: n(e).sex, "onUpdate:modelValue": t[2] || (t[2] = (l) => n(e).sex = l), options: n(ot).ENUM, class: "input-border-none", clearable: "", size: "default", placeholder: "请选择性别", style: { width: "100%", height: "100%" }, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }), a(c, { span: 12 }, { default: o(() => [a(r, { class: "form-item", label: "出生日期", prop: "birthDate" }, { default: o(() => [a(j, { modelValue: n(e).birthDate, "onUpdate:modelValue": t[3] || (t[3] = (l) => n(e).birthDate = l), type: "date", format: "YYYY-MM-DD", "value-format": "YYYY-MM-DD", class: "input-border-none", placeholder: "请选择日期" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), a(_, null, { default: o(() => [a(c, { span: 12 }, { default: o(() => [a(r, { class: "form-item", label: "民族", prop: "nation" }, { default: o(() => [a(u, { modelValue: n(e).nation, "onUpdate:modelValue": t[4] || (t[4] = (l) => n(e).nation = l), placeholder: "请输入民族", class: "input-border-none", style: { width: "100%", height: "100%" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), a(c, { span: 12 }, { default: o(() => [a(r, { class: "form-item", label: "家庭住址", prop: "homeAddress" }, { default: o(() => [a(u, { modelValue: n(e).homeAddress, "onUpdate:modelValue": t[5] || (t[5] = (l) => n(e).homeAddress = l), placeholder: "请输入家庭住址", style: { width: "100%", height: "100%" }, maxlength: "100", class: "input-border-none", size: "default", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }), a(c, { span: 4 }, { default: o(() => [i("div", _t, [a(n(Se), { action: n(Z), accept: "image/*", limit: 1, headers: W.value, "list-type": "picture-card", style: { display: "flex", width: "100%", height: "100%" }, data: { fileType: n(q).NORMAL.V }, class: Be({ disabled: ae.value }), "file-list": n(e).avatarAttachment, "before-upload": be, "on-success": ue, "on-error": he, "on-exceed": _e }, { file: o(({ file: l }) => [a(De, { class: "el-upload-list__item-thumbnail", src: l.imageUrl, alt: "logo", fit: "scale-down" }, null, 8, ["src"]), i("span", gt, [i("span", { class: "el-upload-list__item-preview", onClick: (f) => ye(l) }, [a(z, null, { default: o(() => [a(Ue)]), _: 1 })], 8, bt), i("span", { class: "el-upload-list__item-delete", onClick: (f) => ve(l) }, [a(z, null, { default: o(() => [a(Ne)]), _: 1 })], 8, yt)])]), default: o(() => [a(z, null, { default: o(() => [a(Ee)]), _: 1 })]), _: 1 }, 8, ["action", "headers", "data", "class", "file-list"]), a(Te, { modelValue: E.value, "onUpdate:modelValue": t[6] || (t[6] = (l) => E.value = l) }, { default: o(() => [i("img", { style: { width: "100%" }, src: B.value, alt: "" }, null, 8, vt)]), _: 1 }, 8, ["modelValue"])])]), _: 1 })]), _: 1 }), i("div", It, [a(_, null, { default: o(() => [a(c, { span: 12 }, { default: o(() => [a(r, { class: "form-item", label: "入职日期", prop: "entryDate" }, { default: o(() => [a(j, { modelValue: n(e).entryDate, "onUpdate:modelValue": t[7] || (t[7] = (l) => n(e).entryDate = l), "disabled-date": ge, type: "date", format: "YYYY-MM-DD", class: "input-border-none", "value-format": "x", placeholder: "请选择日期" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), a(c, { span: 12 }, { default: o(() => [a(r, { class: "form-item", label: "工种", prop: "workType" }, { default: o(() => [a(T, { modelValue: n(e).workType, "onUpdate:modelValue": t[8] || (t[8] = (l) => n(e).workType = l), options: n(S).site_work_type, clearable: "", filterable: "", type: "dict", size: "default", class: "input-border-none", placeholder: "请选择工种", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 })]), _: 1 }), a(_, null, { default: o(() => [a(c, { span: 12 }, { default: o(() => [a(r, { class: "form-item", label: "雇主单位", prop: "supplierId" }, { default: o(() => [a(ht, { modelValue: n(e).supplierId, "onUpdate:modelValue": t[9] || (t[9] = (l) => n(e).supplierId = l), projectId: w.projectId, clearable: "", class: "input-border-none", placeholder: "请选择雇主单位", style: { width: "100%", height: "100%" } }, null, 8, ["modelValue", "projectId"])]), _: 1 })]), _: 1 }), a(c, { span: 12 }, { default: o(() => [a(r, { class: "form-item", label: "手机号", prop: "phone" }, { default: o(() => [a(u, { modelValue: n(e).phone, "onUpdate:modelValue": t[10] || (t[10] = (l) => n(e).phone = l), placeholder: "请输入手机号", style: { width: "100%", height: "100%" }, size: "default", clearable: "", class: "input-border-none", onBlur: t[11] || (t[11] = (l) => re(n(e).phone)) }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 })]), i("div", At, [a(_, null, { default: o(() => [a(c, { span: 12 }, { default: o(() => [a(r, { class: "form-item", style: { "border-right": "1px solid #dcdfe6" }, label: "证书", prop: "boolCert" }, { default: o(() => [a(je, { modelValue: n(e).boolCert, "onUpdate:modelValue": t[12] || (t[12] = (l) => n(e).boolCert = l), options: n(v).ENUM, type: "enum", onChange: ie }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 })]), _: 1 }), n(e).boolCert === n(v).YES.V ? (p(), g("div", Vt, [(p(true), g(M, null, R(n(e).certs, (l, f) => (p(), x(_, { key: f }, { default: o(() => [a(c, { span: 12 }, { default: o(() => [a(r, { class: "form-item", label: "证书类型", prop: "certs." + f + ".certType", rules: { required: true, message: "请选择证书类型", trigger: "change" } }, { default: o(() => [a(T, { modelValue: l.certType, "onUpdate:modelValue": (y) => l.certType = y, options: n(S).site_cert_type, clearable: "", filterable: "", type: "dict", size: "default", class: "input-border-none", placeholder: "请选择证书类型" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 2 }, 1032, ["prop"])]), _: 2 }, 1024), a(c, { span: 12, style: { display: "flex", "align-items": "center" } }, { default: o(() => [a(r, { class: "form-item", label: "到期时间", prop: "certs." + f + ".expirationTime", rules: { required: true, message: "请选择到期时间", trigger: "change" }, style: { flex: "1" } }, { default: o(() => [a(j, { modelValue: l.expirationTime, "onUpdate:modelValue": (y) => l.expirationTime = y, class: "input-border-none", type: "date", format: "YYYY-MM-DD", "value-format": "x", placeholder: "请选择日期" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"]), f === 0 ? (p(), x(m, { key: 0, size: "default", type: "success", icon: "el-icon-plus", style: { "margin-left": "4px" }, onClick: we })) : (p(), x(m, { key: 1, size: "default", type: "danger", icon: "el-icon-delete", style: { "margin-left": "4px" }, onClick: (y) => Ce(f) }, null, 8, ["onClick"]))]), _: 2 }, 1024)]), _: 2 }, 1024))), 128))])) : Y("", true)]), i("div", xt, [i("div", wt, [t[17] || (t[17] = i("span", null, "证书：", -1)), a(n(J), { ref: "uploadRef", files: n(e).certAttachments, "onUpdate:files": t[13] || (t[13] = (l) => n(e).certAttachments = l), "file-classify": n(q).NORMAL.V, "show-file-list": false, btnName: "导入", btnType: "primary", accept: ".pdf,.jpg,.jpeg,.png", onChange: ce }, null, 8, ["files", "file-classify"]), (A = n(e).certAttachments) != null && A.length ? (p(), g("div", Ct, [(p(true), g(M, null, R(n(e).certAttachments, (l, f) => (p(), g("div", { key: l.id, style: { width: "100%", "margin-bottom": "10px" } }, [i("div", kt, [i("a", { href: l == null ? void 0 : l.imageUrl, target: "_blank", class: "ellipsis-text", style: { display: "inline-block", width: "160px" } }, [i("span", Dt, H(l == null ? void 0 : l.name), 1)], 8, Et), a(F, { size: "default", icon: "el-icon-delete", type: "danger", style: { "margin-left": "10px" }, onClick: (y) => me(n(e), f) }, null, 8, ["onClick"])])]))), 128))])) : Y("", true)]), i("div", Ut, [t[18] || (t[18] = i("span", null, "体检报告：", -1)), a(n(J), { ref: "uploadRef", files: n(e).physicalExaminationAttachment, "onUpdate:files": t[14] || (t[14] = (l) => n(e).physicalExaminationAttachment = l), "file-classify": n(q).NORMAL.V, "show-file-list": false, btnName: "导入", btnType: "primary", accept: ".pdf,.jpg,.jpeg,.png", onChange: pe }, null, 8, ["files", "file-classify"]), (P = n(e).physicalExaminationAttachment) != null && P.length ? (p(), g("div", Nt, [(p(true), g(M, null, R(n(e).physicalExaminationAttachment, (l, f) => (p(), g("div", { key: l.id, style: { width: "100%", "margin-bottom": "10px" } }, [i("div", Tt, [i("a", { href: l == null ? void 0 : l.imageUrl, target: "_blank", class: "ellipsis-text", style: { display: "inline-block", width: "160px" } }, [i("span", zt, H(l == null ? void 0 : l.name), 1)], 8, jt), a(F, { size: "default", icon: "el-icon-delete", type: "danger", style: { "margin-left": "10px" }, onClick: (y) => fe(n(e), f) }, null, 8, ["onClick"])])]))), 128))])) : Y("", true)])])];
    }), _: 1 }, 8, ["model"]), a(n(ft), { visible: N.value, "onUpdate:visible": t[15] || (t[15] = (A) => N.value = A), data: n(e) }, null, 8, ["visible", "data"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, Gt = et(Mt, [["__scopeId", "data-v-ddbfb04b"]]);
export {
  Gt as default
};
