import { ref as V } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as g } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as e } from "vue";
import { withModifiers as H } from "vue";
import { createVNode as a } from "vue";
import { toDisplayString as n } from "vue";
import { unref as r } from "vue";
import { createElementBlock as u } from "vue";
import { Fragment as k } from "vue";
import { renderList as w } from "vue";
import { createCommentVNode as M } from "vue";
import { ElCol as P } from "element-plus";
import { ElRow as $ } from "element-plus";
import { ElTooltip as F } from "element-plus";
import { ElImage as O } from "element-plus";
import { _ as Q, u as Y, g8 as G, n_ as J, p as x, n$ as K, u6 as W, a as X } from "../../../../shared/runtime.js";
import { h as Z, e as ee } from "../../../../modules/roster-34ff8428.js";
import te from "./qr-code-dlg.vue.js";
import "../../../../modules/index-c549a8fd.js";
import "../../../../modules/html2canvas.esm-e0a7d97b.js";
const se = { class: "item" }, le = { class: "item-content" }, ie = { class: "item" }, ae = { class: "item-content" }, oe = { class: "item" }, ne = { class: "item-content" }, de = { class: "item" }, ce = { class: "item-content" }, _e = { class: "item" }, me = { class: "item-content" }, re = { class: "item" }, ue = { class: "item-content ellipsis-text" }, ve = { class: "img" }, pe = { key: 1, style: { width: "100%", "text-align": "center", color: "#606266" } }, fe = { class: "grop" }, be = { class: "item" }, he = { class: "item-content" }, ye = { class: "item" }, ge = { class: "item-content" }, ke = { class: "item" }, we = { class: "item-content" }, xe = { class: "item" }, Ne = { class: "item-content" }, Ce = { class: "grop" }, Ee = { class: "item" }, Ae = { class: "item-content" }, Ve = { class: "item" }, Ie = { class: "item-content" }, Be = { class: "item" }, De = { class: "item-content" }, Te = { class: "item" }, Ue = { class: "item-content" }, je = { class: "item" }, Re = { class: "item-content ellipsis-text" }, Le = { class: "grop" }, Se = { key: 0 }, qe = { class: "item" }, ze = { class: "item-content" }, He = { class: "item" }, Me = { class: "item-content" }, Pe = { class: "grop" }, $e = { class: "item", style: { height: "152px" } }, Fe = { class: "item-content", style: { overflow: "auto" } }, Oe = { key: 0, class: "file-list" }, Qe = { style: { "margin-left": "6px" } }, Ye = ["href"], Ge = { style: { color: "#409eff !important" } }, Je = { key: 1 }, Ke = { class: "item", style: { height: "152px" } }, We = { class: "item-content", style: { overflow: "auto" } }, Xe = { key: 0, class: "file-list" }, Ze = { style: { "margin-left": "6px" } }, et = ["href"], tt = { style: { color: "#409eff !important" } }, st = { key: 1 }, lt = { __name: "personal-info", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(I, { emit: B }) {
  const D = B, N = I, { visible: T, handleClose: U } = Y({ emit: D, props: N, field: "visible", showHook: S }), h = V(false), i = V(), C = G(["work_type", "cert_type"]);
  async function j() {
    var v;
    try {
      i.value = await Z({ id: N.currentRow.id }), L((v = i.value) == null ? void 0 : v.phone);
    } catch (s) {
      console.log(s);
    }
  }
  function R() {
    h.value = true;
  }
  async function L(v) {
    try {
      const { dept: s, job: p, roles: o, id: m } = await ee({ phone: v });
      if (i.value.deptName = (s == null ? void 0 : s.name) || void 0, i.value.jobName = (p == null ? void 0 : p.name) || void 0, i.value.userId = m || void 0, (o == null ? void 0 : o.length) > 0) {
        const b = o.map((y) => y.name) || [];
        i.value.roleNames = b.join();
      }
    } catch (s) {
      i.value.deptName = void 0, i.value.jobName = void 0, i.value.roleNames = void 0, i.value.roleIds = [], console.log(s);
    }
  }
  function S() {
    j();
  }
  return (v, s) => {
    const p = X, o = P, m = $, b = F, y = O, q = z("common-drawer");
    return _(), g(q, { "append-to-body": "", title: "人员信息详情", visible: r(T), "before-close": r(U), "close-on-click-modal": false, size: "40%" }, { titleAfter: l(() => [e("span", { class: "pointer", onClick: H(R, ["stop"]) }, [a(p, { style: { "font-size": "25px" }, "icon-class": "qr-code" })])]), content: l(() => {
      var E, A;
      return [a(m, { class: "grop" }, { default: l(() => [a(o, { span: 20 }, { default: l(() => [a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", se, [s[1] || (s[1] = e("div", { class: "item-label" }, "姓名:", -1)), e("div", le, n(((t = i.value) == null ? void 0 : t.name) || "-"), 1)])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", ie, [s[2] || (s[2] = e("div", { class: "item-label" }, "身份证号", -1)), e("div", ae, n(((t = i.value) == null ? void 0 : t.idNumber) || "-"), 1)])];
      }), _: 1 })]), _: 1 }), a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", oe, [s[3] || (s[3] = e("div", { class: "item-label" }, "性别:", -1)), e("div", ne, n(r(J).VL[(t = i.value) == null ? void 0 : t.sex] || "-"), 1)])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", de, [s[4] || (s[4] = e("div", { class: "item-label" }, "出生日期:", -1)), e("div", ce, n(r(x)((t = i.value) == null ? void 0 : t.birthDate, "{y}-{m}-{d}")), 1)])];
      }), _: 1 })]), _: 1 }), a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", _e, [s[5] || (s[5] = e("div", { class: "item-label" }, "民族:", -1)), e("div", me, n(((t = i.value) == null ? void 0 : t.nation) || "-"), 1)])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", re, [s[6] || (s[6] = e("div", { class: "item-label" }, "家庭住址:", -1)), a(b, { class: "box-item", effect: "dark", content: (t = i.value) == null ? void 0 : t.homeAddress, placement: "top" }, { default: l(() => {
          var d;
          return [e("div", ue, n(((d = i.value) == null ? void 0 : d.homeAddress) || "-"), 1)];
        }), _: 1 }, 8, ["content"])])];
      }), _: 1 })]), _: 1 })]), _: 1 }), a(o, { span: 4 }, { default: l(() => {
        var t, d;
        return [e("div", ve, [(t = i.value) != null && t.avatarAttachment ? (_(), g(y, { key: 0, style: { width: "100%" }, src: (d = i.value) == null ? void 0 : d.avatarAttachment.imageUrl }, null, 8, ["src"])) : (_(), u("span", pe, "未上传图片"))])];
      }), _: 1 })]), _: 1 }), e("div", fe, [a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", be, [s[7] || (s[7] = e("div", { class: "item-label" }, "员工类别:", -1)), e("div", he, n(r(K).VL[(t = i.value) == null ? void 0 : t.employeeCategory] || "-"), 1)])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", ye, [s[8] || (s[8] = e("div", { class: "item-label" }, "雇主单位:", -1)), e("div", ge, n(((t = i.value) == null ? void 0 : t.supplierName) || "-"), 1)])];
      }), _: 1 })]), _: 1 }), a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", ke, [s[9] || (s[9] = e("div", { class: "item-label" }, "入职日期:", -1)), e("div", we, n(r(x)((t = i.value) == null ? void 0 : t.entryDate, "{y}-{m}-{d}")), 1)])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", xe, [s[10] || (s[10] = e("div", { class: "item-label" }, "工种:", -1)), e("div", Ne, n(r(C).label.work_type[(t = i.value) == null ? void 0 : t.workType] || "-"), 1)])];
      }), _: 1 })]), _: 1 })]), e("div", Ce, [a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", Ee, [s[11] || (s[11] = e("div", { class: "item-label" }, "手机号:", -1)), e("div", Ae, n(((t = i.value) == null ? void 0 : t.phone) || "-"), 1)])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", Ve, [s[12] || (s[12] = e("div", { class: "item-label" }, "员工编号:", -1)), e("div", Ie, n(((t = i.value) == null ? void 0 : t.username) || "-"), 1)])];
      }), _: 1 })]), _: 1 }), a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", Be, [s[13] || (s[13] = e("div", { class: "item-label" }, "部门:", -1)), e("div", De, n(((t = i.value) == null ? void 0 : t.deptName) || "-"), 1)])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", Te, [s[14] || (s[14] = e("div", { class: "item-label" }, "岗位:", -1)), e("div", Ue, n(((t = i.value) == null ? void 0 : t.jobName) || "-"), 1)])];
      }), _: 1 })]), _: 1 }), a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t;
        return [e("div", je, [s[15] || (s[15] = e("div", { class: "item-label" }, "角色:", -1)), a(b, { class: "box-item", effect: "dark", content: (t = i.value) == null ? void 0 : t.roleNames, placement: "top" }, { default: l(() => {
          var d;
          return [e("div", Re, n(((d = i.value) == null ? void 0 : d.roleNames) || "-"), 1)];
        }), _: 1 }, 8, ["content"])])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => s[16] || (s[16] = [e("div", { style: { "border-top": "1px solid #dcdfe6" } }, null, -1)])), _: 1, __: [16] })]), _: 1 })]), e("div", Le, [((E = i.value) == null ? void 0 : E.boolCert) === r(W).YES.V ? (_(), u("div", Se, [(_(true), u(k, null, w((A = i.value) == null ? void 0 : A.certs, (t, d) => (_(), g(m, { key: d }, { default: l(() => [a(o, { span: 12 }, { default: l(() => [e("div", qe, [s[17] || (s[17] = e("div", { class: "item-label" }, "证书类型:", -1)), e("div", ze, n(r(C).label.cert_type[t.certType] || "-"), 1)])]), _: 2 }, 1024), a(o, { span: 12 }, { default: l(() => [e("div", He, [s[18] || (s[18] = e("div", { class: "item-label" }, "到期时间:", -1)), e("div", Me, n(r(x)(t.expirationTime, "{y}-{m}-{d}")), 1)])]), _: 2 }, 1024)]), _: 2 }, 1024))), 128))])) : M("", true)]), e("div", Pe, [a(m, null, { default: l(() => [a(o, { span: 12 }, { default: l(() => {
        var t, d, f;
        return [e("div", $e, [s[19] || (s[19] = e("div", { class: "item-label" }, "证书:", -1)), e("div", Fe, [(d = (t = i.value) == null ? void 0 : t.certAttachments) != null && d.length ? (_(), u("div", Oe, [(_(true), u(k, null, w((f = i.value) == null ? void 0 : f.certAttachments, (c) => (_(), u("div", { key: c.id, style: { width: "100%", "margin-bottom": "10px" } }, [e("div", Qe, [e("a", { href: c == null ? void 0 : c.imageUrl, target: "_blank" }, [e("span", Ge, n(c == null ? void 0 : c.name), 1)], 8, Ye)])]))), 128))])) : (_(), u("div", Je, "-"))])])];
      }), _: 1 }), a(o, { span: 12 }, { default: l(() => {
        var t, d, f;
        return [e("div", Ke, [s[20] || (s[20] = e("div", { class: "item-label" }, "体检报告:", -1)), e("div", We, [(d = (t = i.value) == null ? void 0 : t.physicalExaminationAttachment) != null && d.length ? (_(), u("div", Xe, [(_(true), u(k, null, w((f = i.value) == null ? void 0 : f.physicalExaminationAttachment, (c) => (_(), u("div", { key: c.id, style: { width: "100%", "margin-bottom": "10px" } }, [e("div", Ze, [e("a", { href: c == null ? void 0 : c.imageUrl, target: "_blank" }, [e("span", tt, n(c == null ? void 0 : c.name), 1)], 8, et)])]))), 128))])) : (_(), u("div", st, "-"))])])];
      }), _: 1 })]), _: 1 })]), a(r(te), { visible: h.value, "onUpdate:visible": s[0] || (s[0] = (t) => h.value = t), data: i.value }, null, 8, ["visible", "data"])];
    }), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, _t = Q(lt, [["__scopeId", "data-v-2acb330a"]]);
export {
  _t as default
};
